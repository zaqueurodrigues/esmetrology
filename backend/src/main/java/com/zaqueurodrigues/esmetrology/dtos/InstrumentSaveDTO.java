package com.zaqueurodrigues.esmetrology.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class InstrumentSaveDTO {
	
	@NotBlank
	private String tag;
	@NotBlank
	private String description;
	@NotBlank
	private String type;
	@NotBlank
	private String range;
	@NotBlank
	private String frequency;
	@NotBlank
	private Long departmentId;

}
