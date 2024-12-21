package com.aevum.tec.login;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aevum.tec.dto.MobileUserDTO;
import com.aevum.tec.exception.GeneralException;
import com.aevum.tec.message.model.MessageModel;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth/")
public class UserAuthController {

	private final UserAuthService authService;

	public UserAuthController(UserAuthService authService) {
		this.authService = authService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<MobileUserDTO>> getAllUsers() {
		return ResponseEntity.ok(authService.getAllUsers());
	}

	@PostMapping("/createUser")
	public ResponseEntity<MobileUserDTO> createUser(@RequestBody MobileUserDTO user) {
		return ResponseEntity.ok(authService.createUser(user));
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<MessageModel> deleteUserById(@PathVariable String id) throws GeneralException {
		MessageModel res = authService.deleteUserById(id);
		return new ResponseEntity<MessageModel>(res, HttpStatus.ACCEPTED);
	}

	@PostMapping("/register")
	public ResponseEntity<MessageModel> registration(@RequestBody MobileUserDTO user, HttpServletRequest request,
			@RequestHeader(required = true) String company) {
		MessageModel res = authService.registration(user, request);
		return new ResponseEntity<MessageModel>(res, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<MessageModel> userLogin(@RequestBody MobileUserDTO user,
			@RequestHeader(required = true) String company) {
		MessageModel res = authService.userLogin(user);
		return new ResponseEntity<MessageModel>(res, HttpStatus.ACCEPTED);
	}
}
