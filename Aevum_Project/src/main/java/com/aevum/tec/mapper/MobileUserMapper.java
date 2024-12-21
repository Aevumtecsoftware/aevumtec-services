package com.aevum.tec.mapper;

import java.util.List;

import org.mapstruct.Mapper;


import com.aevum.tec.dto.MobileUserDTO;
import com.aevum.tec.entity.MobileUser;

@Mapper(componentModel = "spring")
public interface MobileUserMapper {

	MobileUserDTO toUserDTO(MobileUser user);

	MobileUser toUser(MobileUserDTO userDTO);

	List<MobileUserDTO> toUserDTOs(List<MobileUser> users);

	List<MobileUser> toUsers(List<MobileUserDTO> userDTOs);
}
