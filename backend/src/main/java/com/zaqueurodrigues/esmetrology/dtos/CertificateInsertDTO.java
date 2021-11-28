package com.zaqueurodrigues.esmetrology.dtos;

import java.time.Instant;

import lombok.Data;

@Data
public class CertificateInsertDTO {

	private String code;
	private Instant calibrationDate;
	private Instant publishDate;
	private InstrumentSaveDTO instrument;
	private LabViewDTO lab;

}
