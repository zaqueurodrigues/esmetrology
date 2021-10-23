package com.zaqueurodrigues.esmetrology.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserViewDTO {

	private String name;
	private String email;
	private DepartmentViewDTO department;

}
