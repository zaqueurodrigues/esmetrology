package com.zaqueurodrigues.esmetrology.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

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
	
	public InstrumentSaveDTO() {
		super();
	}
	public InstrumentSaveDTO(Long id, @NotBlank String tag, @NotBlank String description, @NotBlank String type,
			@NotBlank String range, @NotBlank String frequency, @NotNull Long departmentId,
			@NotBlank InstrumentStatus status, String note) {
		super();
		this.id = id;
		this.tag = tag;
		this.description = description;
		this.type = type;
		this.range = range;
		this.frequency = frequency;
		this.departmentId = departmentId;
		this.status = status;
		this.note = note;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartment(Long departmentId) {
		this.departmentId = departmentId;
	}
	public InstrumentStatus getStatus() {
		return status;
	}
	public void setStatus(InstrumentStatus status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
