package com.zaqueurodrigues.esmetrology.dtos.instruments;

import com.zaqueurodrigues.esmetrology.dtos.DepartmentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

import lombok.Data;

@Data
public class InstrumentViewDTO {
	
	private String tag;
	private String serie;
	private String mark;
	private String description;
	private String type;
	private String range;
	private String frequency;
	private InstrumentStatus status;
	private String note;
	private DepartmentViewDTO department;

}
