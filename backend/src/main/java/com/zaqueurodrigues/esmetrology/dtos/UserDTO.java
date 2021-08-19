package com.zaqueurodrigues.esmetrology.dtos;

import java.io.Serializable;

import com.zaqueurodrigues.esmetrology.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String enrollment;
	
	private String email;
	
	private Long departmentId;
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String name, String enrollment, String email, Long departmentId) {
		this.id = id;
		this.name = name;
		this.enrollment = enrollment;
		this.email = email;
		this.departmentId = departmentId;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		enrollment = entity.getEnrollment();
		email = entity.getEmail();
		departmentId = entity.getDepartment().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
