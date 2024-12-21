package com.aevum.tec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.aevum.tec.dto.MAppCodesDTO;
import com.aevum.tec.entity.MAppCodes;

@Mapper(componentModel = "spring")
public interface CommonMapper {

	MAppCodesDTO toUserDTO(MAppCodes user);

	MAppCodes toUser(MAppCodesDTO userDTO);

	List<MAppCodesDTO> toUserDTOs(List<MAppCodes> users);

	List<MAppCodes> toUsers(List<MAppCodesDTO> userDTOs);

}
