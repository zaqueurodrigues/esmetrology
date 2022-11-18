package com.zaqueurodrigues.esmetrology.dtos;

import javax.validation.constraints.NotBlank;

import com.zaqueurodrigues.esmetrology.entities.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentViewDTO {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	public DepartmentViewDTO(Department entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
}
