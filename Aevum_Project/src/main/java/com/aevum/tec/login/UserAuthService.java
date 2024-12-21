package com.aevum.tec.login;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aevum.tec.ApplicationConstants;
import com.aevum.tec.dto.MobileUserDTO;
import com.aevum.tec.entity.MobileUser;
import com.aevum.tec.exception.GeneralException;
import com.aevum.tec.mapper.MobileUserMapper;
import com.aevum.tec.message.model.MessageModel;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserAuthService {

	private static final Logger logger = LoggerFactory.getLogger(UserAuthService.class);
	private final MobileUserMapper userMapper;
	private final MessageModel message;

	public UserAuthService(MobileUserMapper userMapper, MessageModel message) {
		this.userMapper = userMapper;
		this.message = message;
	}

	@Autowired
	private UserAuthRepository uathRepo;

	public List<MobileUserDTO> getAllUsers() {
		logger.info("Enter getAllUsers service");
		return userMapper.toUserDTOs(uathRepo.findAll());
	}

	public MobileUserDTO createUser(MobileUserDTO userDTO) {
		MobileUser user = userMapper.toUser(userDTO);
		MobileUser savedUser = uathRepo.save(user);
		return userMapper.toUserDTO(savedUser);
	}

	public MessageModel deleteUserById(String id) throws GeneralException {
		logger.info("Enter deleteUserById service");
		if (uathRepo.existsById(id)) {
			uathRepo.deleteById(id);
			message.setMessage("User with ID " + id + " deleted successfully.");
			message.setMessageType(ApplicationConstants.STATUS_SUCCESS);
		} else {
			throw new GeneralException(1001, "User with ID " + id + " deleted failed.");
		}
		logger.info("Exit deleteUserById service");
		return message;
	}

	public MessageModel registration(MobileUserDTO userDTO, HttpServletRequest request) {
		logger.info("Enter registration service");
		String deviceInfo = request.getHeader("User-Agent");
		String ipAddress = request.getRemoteAddr();
		userDTO.setDeviceMake(deviceInfo);
		userDTO.setIpAddress(ipAddress);
		userDTO.setImei(UUID.randomUUID().toString());
		userDTO.setStatus(Optional.ofNullable(userDTO.getStatus()).filter(s -> !s.isEmpty()).orElse("0"));
		userDTO.setLocked(Optional.ofNullable(userDTO.getLocked()).filter(l -> !l.isEmpty()).orElse("0"));
		userDTO.setCreatedBy(Optional.ofNullable(userDTO.getName()).filter(c -> !c.isEmpty()).orElse("Guest"));
		userDTO.setUpdatedBy(Optional.ofNullable(userDTO.getName()).filter(u -> !u.isEmpty()).orElse("Guest"));
		userDTO.setResetOtp(generateRandomOtp());

		MobileUser user = userMapper.toUser(userDTO);
		try {
			uathRepo.save(user);
			message.setMessage("Register successfully.");
			message.setMessageType(ApplicationConstants.STATUS_SUCCESS);
		} catch (Exception e) {
			message.setMessage("Register failed.");
			message.setMessageType(ApplicationConstants.STATUS_FAILURE);
		}

		logger.info("Exit registration service");
		return message;
	}

	private String generateRandomOtp() {
		Random random = new Random();
		String otp = String.valueOf(1000 + random.nextInt(9000));
		return otp;
	}

	public MessageModel userLogin(MobileUserDTO userDTO) {
		logger.info("Enter userLogin service");
		Optional.ofNullable(userDTO.getMobileNo()).filter(m -> !m.isEmpty())
				.orElseThrow(() -> new GeneralException(1001, "Mobile number cannot be null or empty"));
		Optional<MobileUser> user = uathRepo.findById(userDTO.getMobileNo());
		if (user.isEmpty()) {
			throw new GeneralException(1001, "Please register and signup");
		}
		userDTO.setResetOtp(generateRandomOtp());
	    MobileUser userEntity = userMapper.toUser(userDTO);
	    userEntity.setUpdatedDate(new Date());
		int rowsUpdated = uathRepo.updateMurestotpById(userEntity.getMobileNo(), userEntity.getResetOtp(), userEntity.getUpdatedDate());
		if (rowsUpdated == 0) {
			throw new GeneralException(1003, "Failed to update OTP. Please try again.");
		}
		message.setMessage("OTP has been sent to the registered mobile number.");
		message.setMessageType(ApplicationConstants.STATUS_SUCCESS);
		message.setOtp(userEntity.getResetOtp());
		logger.info("Exit userLogin service");
		return message;
	}
}
