package com.zaqueurodrigues.esmetrology.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zaqueurodrigues.esmetrology.dtos.DepartmentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

	DepartmentViewDTO parseViewDTO(Department department);
	
	Department parseDepartment(DepartmentViewDTO departmentViewDTO);
}
