package com.zaqueurodrigues.esmetrology.mappers;

import org.mapstruct.Mapper;

import com.zaqueurodrigues.esmetrology.dtos.LabViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Lab;

@Mapper(componentModel = "spring")
public interface LabMapper {
	
	LabViewDTO parseViewDTO(Lab lab);
	
	Lab parseLab(LabViewDTO labViewDTO);

}
