package com.zaqueurodrigues.esmetrology.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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

import lombok.Data;

@Entity
@Table(name = "tb_instrument")
@Data
public class Instrument  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tag;
	private String serie;
	private String mark;
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
	private List<Certificate> certificates = new ArrayList<>();

}
