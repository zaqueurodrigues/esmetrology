package com.zaqueurodrigues.esmetrology.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaqueurodrigues.esmetrology.dtos.InstrumentSaveDTO;
import com.zaqueurodrigues.esmetrology.dtos.InstrumentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.entities.Instrument;
import com.zaqueurodrigues.esmetrology.entities.User;
import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;
import com.zaqueurodrigues.esmetrology.mappers.InstrumentMapper;
import com.zaqueurodrigues.esmetrology.repositories.DepartmentRepository;
import com.zaqueurodrigues.esmetrology.repositories.InstrumentRepository;
import com.zaqueurodrigues.esmetrology.services.exceptions.DatabaseException;
import com.zaqueurodrigues.esmetrology.services.exceptions.ResourceNotFoundException;

@Service
public class InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private AuthService authService;

	@Autowired
	private InstrumentMapper instrumentMapper;

	@Transactional(readOnly = true)
	public Page<InstrumentViewDTO> findAll(String tag, Long departmentId, String description, Pageable pageable) {

		User user = authService.authenticated();

		if (!user.hasRole("ROLE_ADMIN")) {

			Department department = departmentRepository.getById(user.getDepartment().getId());
			Page<Instrument> result = instrumentRepository.findByDepartment(department, pageable);
			return result.map(instrument -> instrumentMapper.parseViewDto(instrument));
		}

		Department department = (departmentId == 0) ? null : departmentRepository.getById(departmentId);
		Page<Instrument> page = instrumentRepository.find(tag, department, description, pageable);
		instrumentRepository.findInstrumentWithDepartment(page.getContent());

		return page.map(inst -> instrumentMapper.parseViewDto(inst));

	}

	@Transactional
	public InstrumentViewDTO insert(InstrumentSaveDTO dto) {
		Instrument instrument = instrumentMapper.parseInstrument(dto);
		if(dto.getStatus() == null) {
			instrument.setStatus(InstrumentStatus.ACTIVE);
		}
		
		Optional<Department> departmentOp = departmentRepository.findById(dto.getDepartmentId());

		if (!departmentOp.isPresent()) {
			throw new ResourceNotFoundException("Department not exists: " + dto.getDepartmentId());
		}

		instrument.setDepartment(departmentOp.get());

		instrument = instrumentRepository.save(instrument);

		return instrumentMapper.parseViewDto(instrument);

	}

	@Transactional
	public InstrumentViewDTO update(Long id, InstrumentSaveDTO dto) {
		dto.setId(id);
		Optional<Department> departmentOp = departmentRepository.findById(dto.getDepartmentId());

		if (!departmentOp.isPresent()) {
			throw new ResourceNotFoundException("Incorrect department id!");
		}
		var department = departmentOp.get();

		var instrument = instrumentRepository.getById(id);

		instrument = instrumentMapper.parseInstrument(dto);
		instrument.setDepartment(department);
		instrument = instrumentRepository.save(instrument);
		return instrumentMapper.parseViewDto(instrument);

	}
	
	public void delete(Long id) {
		try {
			instrumentRepository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " +id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

}
