package com.zaqueurodrigues.esmetrology.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaqueurodrigues.esmetrology.dtos.RoleViewDTO;
import com.zaqueurodrigues.esmetrology.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public List<RoleViewDTO> findAll() {
		return repository.findAll().stream().map(rol -> new RoleViewDTO(rol)).collect(Collectors.toList());
	}
	

}
