package com.zaqueurodrigues.esmetrology.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.zaqueurodrigues.esmetrology.entities.Certificate;

public class CertificateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String code;
	private Instant calibrationDate;
	private Instant publishDate;
	
	public CertificateDTO() {
		
	}

	public CertificateDTO(Long id, String code, Instant calibrationDate, Instant publishDate) {
		this.id = id;
		this.code = code;
		this.calibrationDate = calibrationDate;
		this.publishDate = publishDate;
	}
	
	public CertificateDTO(Certificate entity) {
		id = entity.getId();
		code = entity.getCode();
		calibrationDate = entity.getCalibrationDate();
		publishDate = entity.getPublishDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
