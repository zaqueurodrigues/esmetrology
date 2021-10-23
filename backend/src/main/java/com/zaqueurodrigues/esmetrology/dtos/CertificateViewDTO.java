package com.zaqueurodrigues.esmetrology.dtos;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateViewDTO  {
	
	private String code;
	private Instant calibrationDate;
	private Instant publishDate;
	
}
