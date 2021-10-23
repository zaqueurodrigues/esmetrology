package com.zaqueurodrigues.esmetrology.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaqueurodrigues.esmetrology.dtos.LabViewDTO;
import com.zaqueurodrigues.esmetrology.repositories.LabRepository;

@Service
public class LabService {
	
	@Autowired
	private LabRepository labRepository;
	
	@Transactional(readOnly = true)
	public Page<LabViewDTO> findAll(Pageable pageable) {
		return labRepository.findAll(pageable).map(lab -> LabViewDTO.toLab(lab));
	}

	
}
