package com.zaqueurodrigues.esmetrology.mappers;

import org.mapstruct.Mapper;

import com.zaqueurodrigues.esmetrology.dtos.UserViewDTO;
import com.zaqueurodrigues.esmetrology.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserViewDTO parseViewDTO(User user);
	
	User parseLab(UserViewDTO userViewDTO);

}
