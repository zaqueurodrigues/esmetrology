package com.zaqueurodrigues.esmetrology.dtos.users;

import java.util.HashSet;
import java.util.Set;

import com.zaqueurodrigues.esmetrology.dtos.DepartmentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Role;
import com.zaqueurodrigues.esmetrology.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserViewDTO {

	private Long id;
	private String name;
	private String enrollment;
	private String email;
	private DepartmentViewDTO department;
	private Set<Role> roles = new HashSet<>();
	
	public UserViewDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.enrollment = entity.getEnrollment();
		this.email = entity.getEmail();
		this.department = new DepartmentViewDTO(entity.getDepartment());
		this.roles = entity.getRoles();
	}
}
