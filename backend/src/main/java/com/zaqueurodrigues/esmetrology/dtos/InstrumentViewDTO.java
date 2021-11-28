package com.zaqueurodrigues.esmetrology.dtos;

import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

import lombok.Data;

@Data
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
