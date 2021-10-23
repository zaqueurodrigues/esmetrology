package com.zaqueurodrigues.esmetrology.dtos;

import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentViewDTO {
	
	private String tag;
	private String description;
	private String type;
	private String range;
	private String frequency;
	private InstrumentStatus status;
	private String note;
	private DepartmentViewDTO department;
	
}
