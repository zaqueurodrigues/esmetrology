package com.zaqueurodrigues.esmetrology.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserViewDTO {

	private String name;
	private String email;
	private DepartmentViewDTO department;
	
	public static UserViewDTO toUser(com.zaqueurodrigues.esmetrology.entities.User user) {
		return UserViewDTO.builder()
				.name(user.getName())
				.email(user.getEmail())
				.department(new DepartmentViewDTO(user.getDepartment().getName()))
				.build();
				
	}
	

}
