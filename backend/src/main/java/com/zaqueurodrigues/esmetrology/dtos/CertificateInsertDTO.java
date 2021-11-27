package com.zaqueurodrigues.esmetrology.dtos;

import java.time.Instant;


public class CertificateInsertDTO {
	
	private String code;
	private Instant calibrationDate;
	private Instant publishDate;
	private InstrumentSaveDTO instrument;
	private LabViewDTO lab;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Instant getCalibrationDate() {
		return calibrationDate;
	}
	public void setCalibrationDate(Instant calibrationDate) {
		this.calibrationDate = calibrationDate;
	}
	public Instant getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Instant publishDate) {
		this.publishDate = publishDate;
	}
	public InstrumentSaveDTO getInstrument() {
		return instrument;
	}
	public void setInstrument(InstrumentSaveDTO instrument) {
		this.instrument = instrument;
	}
	public LabViewDTO getLab() {
		return lab;
	}
	public void setLab(LabViewDTO lab) {
		this.lab = lab;
	}
	

}
