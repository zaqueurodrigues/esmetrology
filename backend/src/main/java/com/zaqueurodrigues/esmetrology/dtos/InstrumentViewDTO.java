package com.zaqueurodrigues.esmetrology.dtos;

import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

public class InstrumentViewDTO {
	
	private String tag;
	private String description;
	private String type;
	private String range;
	private String frequency;
	private InstrumentStatus status;
	private String note;
	private DepartmentViewDTO department;
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
	public DepartmentViewDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentViewDTO department) {
		this.department = department;
	}
	
	
}
