package com.zaqueurodrigues.esmetrology.dtos;

import javax.validation.constraints.NotBlank;

import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	private Long department;
	@NotBlank
	private InstrumentStatus status;

}
