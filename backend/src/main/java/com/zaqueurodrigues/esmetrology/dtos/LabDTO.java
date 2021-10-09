package com.zaqueurodrigues.esmetrology.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private String accreditationNumber;

}
