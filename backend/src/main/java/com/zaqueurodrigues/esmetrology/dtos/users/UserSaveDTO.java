package com.zaqueurodrigues.esmetrology.dtos.users;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class UserSaveDTO {
	
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String enrollment;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotNull
	private DepartmentViewDTO department;
	
	@NotNull
	private Set<Role> roles = new HashSet<>();
	
	public UserSaveDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.enrollment = entity.getEnrollment();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
		this.roles = entity.getRoles();
		this.department = new DepartmentViewDTO(entity.getDepartment());
	}
	
	
}
