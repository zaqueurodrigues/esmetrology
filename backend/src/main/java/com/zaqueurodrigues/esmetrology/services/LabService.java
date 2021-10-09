package com.zaqueurodrigues.esmetrology.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaqueurodrigues.esmetrology.dtos.LabDTO;
import com.zaqueurodrigues.esmetrology.repositories.LabRepository;

@Service
public class LabService {
	
	@Autowired
	private LabRepository labRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
	public Page<LabDTO> findAll(Pageable pageable) {
		return labRepository.findAll(pageable).map(lab -> modelMapper.map(lab, LabDTO.class));
	}

	
}
