package com.zaqueurodrigues.esmetrology.dtos;

import java.time.Instant;

import lombok.Data;

@Data
public class CertificateViewDTO {

	private String code;
	private Instant calibrationDate;
	private Instant publishDate;
	private InstrumentViewDTO instrument;

}
