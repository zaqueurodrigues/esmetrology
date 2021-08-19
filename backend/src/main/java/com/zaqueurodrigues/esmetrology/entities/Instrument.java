package com.zaqueurodrigues.esmetrology.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;

@Entity
@Table(name = "tb_instrument")
public class Instrument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tag;
	
	private String description;
	
	private String type;
	
	private String range;
	
	private String frequency;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant lastCalibration;
	
	private InstrumentStatus status;
	
	@Column(columnDefinition = "TEXT")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@OneToMany(mappedBy = "instrument")
	private Set<Certificate> certificates = new HashSet<>();

	public Instrument() {
	
	}

	public Instrument(Long id, String tag, String description, String type, String range, String frequency, Instant lastCalibration,
			InstrumentStatus status, String note, Department department) {
		super();
		this.id = id;
		this.tag = tag;
		this.description = description;
		this.type = type;
		this.range = range;
		this.frequency = frequency;
		this.lastCalibration = lastCalibration;
		this.status = status;
		this.note = note;
		this.department = department;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Certificate> getCertificates() {
		return certificates;
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
		Instrument other = (Instrument) obj;
		return Objects.equals(id, other.id);
	}

}
