package com.zaqueurodrigues.esmetrology.entities;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_certificate")
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant calibrationDate;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant publishDate;
	@ManyToOne
	@JoinColumn(name = "instrument_id")
	private Instrument instrument;
	@ManyToOne
	@JoinColumn(name = "lab_id")
	private Lab lab;
	
	public Certificate() {
		
	}

	public Certificate(Long id, String code, Instant calibrationDate, Instant publishDate, Instrument instrument,
			Lab lab) {
		super();
		this.id = id;
		this.code = code;
		this.calibrationDate = calibrationDate;
		this.publishDate = publishDate;
		this.instrument = instrument;
		this.lab = lab;
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

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificate other = (Certificate) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
