package com.aevum.tec.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.aevum.tec.ApplicationConstants;
import com.aevum.tec.dto.FilterDTO;
import com.aevum.tec.dto.MAppCodesDTO;
import com.aevum.tec.entity.MAppCodes;
import com.aevum.tec.exception.GeneralException;
import com.aevum.tec.mapper.CommonMapper;
import com.aevum.tec.message.model.MessageModel;
import com.aevum.tec.repository.MAppCodesRepository;

@Service
public class CommonService {

	private static final Logger logger = LoggerFactory.getLogger(CommonService.class);
	private final CommonMapper comMapper;
	private final MessageModel message;
	private final MAppCodesRepository mAppCodesRepository;

	public CommonService(CommonMapper comMapper, MessageModel message, MAppCodesRepository mAppCodesRepository) {
		this.comMapper = comMapper;
		this.message = message;
		this.mAppCodesRepository = mAppCodesRepository;
	}

		public MessageModel getApplCodesList(MAppCodesDTO bean) {
			logger.info("Enter getApplCodesList service");
	
			// Validate input DTO
			Optional.ofNullable(bean).orElseThrow(() -> new GeneralException(1001, "Input data cannot be null"));
	
			String type = bean.getType();
			FilterDTO filter = bean.getFilter();
			List<MAppCodes> entities = new ArrayList<>();
	
			try {
				if (StringUtils.isNotBlank(type)) {
					logger.info("Fetching entities by type and date range");
					entities = mAppCodesRepository.findByTypeAndDateRange(type);
				}
				if (filter != null) {
					logger.debug("Entities retrieved from repository: {}", entities);
					entities = entities.stream()
						    .filter(entity -> {
						        logger.debug("Entity MasterDefCode: {}, Filter Data1: {}", entity.getMasterDefCode(), filter.getData1());
						        return StringUtils.isBlank(filter.getData1()) || 
						               (StringUtils.isNotBlank(entity.getMasterDefCode()) && 
						                entity.getMasterDefCode().equalsIgnoreCase(filter.getData1()));
						    })
						    .filter(entity -> {
						        logger.debug("Entity MainCode: {}, Filter Data2: {}", entity.getMainCode(), filter.getData2());
						        return StringUtils.isBlank(filter.getData2()) || 
						               (StringUtils.isNotBlank(entity.getMainCode()) && 
						                entity.getMainCode().equalsIgnoreCase(filter.getData2()));
						    })
						    .filter(entity -> {
						        logger.debug("Entity MapCode: {}, Filter Data3: {}", entity.getMapCode(), filter.getData3());
						        return StringUtils.isBlank(filter.getData3()) || 
						               (StringUtils.isNotBlank(entity.getMapCode()) && 
						                entity.getMapCode().equalsIgnoreCase(filter.getData3()));
						    })
						    .collect(Collectors.toList());

					if ("desc".equalsIgnoreCase(filter.getOrderBy())) {
						entities.sort(Comparator.comparing(MAppCodes::getCode).reversed());
					} else {
						entities.sort(Comparator.comparing(MAppCodes::getCode));
					}
				}
				List<MAppCodesDTO> dtoList = comMapper.toUserDTOs(entities);
	
				message.setMessage("Data retrieved successfully");
				message.setMessageType(ApplicationConstants.STATUS_SUCCESS);
				message.setData(dtoList);
	
				logger.info("Exit getApplCodesList service");
				return message;
	
			} catch (Exception e) {
				logger.error("Error occurred in getApplCodesList service", e);
				throw new GeneralException(1002, "Failed to fetch application codes");
			}
		}

}