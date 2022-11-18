package com.zaqueurodrigues.esmetrology.dtos.instruments;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class InstrumentSaveDTO {
	
	private Long id;
	@NotBlank
	private String tag;
	@NotBlank
	private String serie;
	private String mark;
	@NotBlank
	private String description;
	@NotBlank
	private String type;
	@NotBlank
	private String range;
	@NotBlank
	private String frequency;
	@NotNull
	private DepartmentViewDTO department;
	
	private InstrumentStatus status;
	private String note;
	
	public InstrumentSaveDTO(Instrument entity) {
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
