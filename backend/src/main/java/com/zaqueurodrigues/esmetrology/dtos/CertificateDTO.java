package com.zaqueurodrigues.esmetrology.dtos;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String code;
	private Instant calibrationDate;
	private Instant publishDate;
	
}
