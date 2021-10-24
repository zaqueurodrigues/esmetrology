package com.zaqueurodrigues.esmetrology.dtos;

import java.time.Instant;


public class CertificateViewDTO  {
	
	private String code;
	private Instant calibrationDate;
	private Instant publishDate;
	
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
	
	
	
}
