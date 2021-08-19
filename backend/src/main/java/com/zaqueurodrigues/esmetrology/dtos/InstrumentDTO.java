package com.zaqueurodrigues.esmetrology.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.zaqueurodrigues.esmetrology.entities.Instrument;
import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

public class InstrumentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String tag;
	private String description;
	private String type;
	private String range;
	private String frequency;
	private Instant lastCalibration;
	private InstrumentStatus status;
	private String note;
	private CertificateDTO lastCertificate;
	
	public InstrumentDTO() {
		
	}

	public InstrumentDTO(Long id, String tag, String description, String type, String range, String frequency,
			Instant lastCalibration, InstrumentStatus status, String note, CertificateDTO lastCertificate) {
		this.id = id;
		this.tag = tag;
		this.description = description;
		this.type = type;
		this.range = range;
		this.frequency = frequency;
		this.lastCalibration = lastCalibration;
		this.status = status;
		this.note = note;
		this.lastCertificate = lastCertificate;
	}
	
	public InstrumentDTO(Instrument entity) {
		id = entity.getId();
		tag = entity.getTag();
		description = entity.getDescription();
		type = entity.getType();
		range = entity.getRange();
		frequency = entity.getFrequency();
		lastCalibration = entity.getLastCalibration();
		status = entity.getStatus();
		note = entity.getNote();
		
		if(!entity.getCertificates().isEmpty()) {
			lastCertificate= new CertificateDTO(entity.getCertificates().get(entity.getCertificates().size()-1));
		} else {
			lastCertificate = null;
		}
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Instant getLastCalibration() {
		return lastCalibration;
	}

	public void setLastCalibration(Instant lastCalibration) {
		this.lastCalibration = lastCalibration;
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

	public CertificateDTO getLastCertificate() {
		return lastCertificate;
	}

	public void setLastCertificate(CertificateDTO lastCertificate) {
		this.lastCertificate = lastCertificate;
	}
	
}
