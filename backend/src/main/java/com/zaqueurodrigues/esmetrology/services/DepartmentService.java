package com.zaqueurodrigues.esmetrology.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.zaqueurodrigues.esmetrology.dtos.DepartmentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.mappers.DepartmentMapper;
import com.zaqueurodrigues.esmetrology.repositories.DepartmentRepository;
import com.zaqueurodrigues.esmetrology.services.exceptions.DatabaseException;
import com.zaqueurodrigues.esmetrology.services.exceptions.ResourceNotFoundException;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private DepartmentMapper departmentMapper;

	public DepartmentViewDTO findByid(Long id) {
		Optional<Department> opt = departmentRepository.findById(id);

		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("Department not found!");
		}

		return departmentMapper.parseViewDTO(opt.get());
	}

	public DepartmentViewDTO insert(DepartmentViewDTO dto) {
		Department department = departmentMapper.parseDepartment(dto);
		department = departmentRepository.save(department);
		return departmentMapper.parseViewDTO(department);
	}

	public DepartmentViewDTO update(Long id, DepartmentViewDTO dto) {
		dto.setId(id);
		Optional<Department> departmentOp = departmentRepository.findById(id);

		if (!departmentOp.isPresent()) {
			throw new ResourceNotFoundException("Incorrect department id!");
		}
		var department = departmentOp.get();
		
		department.setName(dto.getName());
		department = departmentRepository.save(department);
		return departmentMapper.parseViewDTO(department);

	}

	public void delete(Long id) {
		try {
			departmentRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

}
