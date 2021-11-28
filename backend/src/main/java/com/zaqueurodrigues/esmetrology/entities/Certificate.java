package com.zaqueurodrigues.esmetrology.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_certificate")
@Data
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

}
