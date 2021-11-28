package com.zaqueurodrigues.esmetrology.dtos;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class DepartmentViewDTO {
	
	@JsonIgnore
	private Long id;
	
	@NotBlank
	private String name;
}
