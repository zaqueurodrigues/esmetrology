package com.zaqueurodrigues.esmetrology.dtos;

import com.zaqueurodrigues.esmetrology.entities.Department;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentViewDTO {

	private String name;
	
	public DepartmentViewDTO toDepartment(Department department) {
		return DepartmentViewDTO.builder().name(department.getName()).build();
	}
}
