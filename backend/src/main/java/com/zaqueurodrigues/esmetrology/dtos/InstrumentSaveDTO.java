package com.zaqueurodrigues.esmetrology.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

import lombok.Data;

@Data
public class InstrumentSaveDTO {
	
	private Long id;
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
	@NotNull
	private Long departmentId;
	
	private InstrumentStatus status;
	private String note;
	
}
