package com.zaqueurodrigues.esmetrology.dtos;

import lombok.Data;

@Data
public class UserViewDTO {

	private String name;
	private String email;
	private DepartmentViewDTO department;
}
