package com.zaqueurodrigues.esmetrology.dtos;

import javax.validation.constraints.NotBlank;

import com.zaqueurodrigues.esmetrology.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleViewDTO {
	
	private Long id;
	
	@NotBlank
	private String authority;
	
	public RoleViewDTO(Role entity) {
		this.id = entity.getId();
		this.authority = entity.getAuthority();
	}
	
}
