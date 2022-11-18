package com.zaqueurodrigues.esmetrology.dtos.instruments;

import com.zaqueurodrigues.esmetrology.dtos.DepartmentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Instrument;
import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentViewDTO {
	
	private Long id;
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
	
	public InstrumentViewDTO(Instrument entity) {
		this.id = entity.getId();
		this.tag = entity.getTag();
		this.serie = entity.getSerie();
		this.mark = entity.getMark();
		this.description = entity.getDescription();
		this.type = entity.getType();
		this.range = entity.getRange();
		this.frequency = entity.getFrequency();
		this.status = entity.getStatus();
		this.note = entity.getNote();
		this.department = new DepartmentViewDTO(entity.getDepartment());
	}

}
