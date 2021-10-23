package com.zaqueurodrigues.esmetrology.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaqueurodrigues.esmetrology.dtos.DepartmentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.mappers.DepartmentMapper;
import com.zaqueurodrigues.esmetrology.repositories.DepartmentRepository;
import com.zaqueurodrigues.esmetrology.services.exceptions.ResourceNotFoundException;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Transactional(readOnly = true)
	public DepartmentViewDTO findByDepartmentName(String name) {
		Optional<Department> opt = departmentRepository.findByName(name);
		
		if(!opt.isPresent()) {
			throw new ResourceNotFoundException("Department not found!");
		}
		
		return departmentMapper.parseViewDTO(opt.get());
	}

}
