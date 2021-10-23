package com.zaqueurodrigues.esmetrology.dtos;

import java.time.Instant;

import com.zaqueurodrigues.esmetrology.entities.Certificate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CertificateViewDTO  {
	
	private String code;
	private Instant calibrationDate;
	private Instant publishDate;
	
	public CertificateViewDTO toCertificate(Certificate certificate) {
		return CertificateViewDTO.builder()
				.code(certificate.getCode())
				.calibrationDate(certificate.getCalibrationDate())
				.publishDate(certificate.getPublishDate())
				.build();
	}
	
}
