package com.zaqueurodrigues.esmetrology.dtos;

import lombok.Data;

@Data
public class UserViewDTO {

	private Long id;
	private String name;
	private String email;
	private DepartmentViewDTO department;
}
