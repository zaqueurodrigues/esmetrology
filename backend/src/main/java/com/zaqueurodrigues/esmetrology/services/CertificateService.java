package com.zaqueurodrigues.esmetrology.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaqueurodrigues.esmetrology.dtos.CertificateInsertDTO;
import com.zaqueurodrigues.esmetrology.dtos.CertificateViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Certificate;
import com.zaqueurodrigues.esmetrology.mappers.CertificateMapper;
import com.zaqueurodrigues.esmetrology.repositories.CertificateRepository;

@Service
public class CertificateService {
	
	@Autowired
	private CertificateRepository certificateRepository;
	
	@Autowired
	private CertificateMapper certificateMapper;
	
	public CertificateViewDTO insert(CertificateInsertDTO dto) {
		Certificate model = certificateMapper.parseCertificate(dto);
		certificateRepository.save(model);
		return certificateMapper.parseViewDTO(model);
	}

}
