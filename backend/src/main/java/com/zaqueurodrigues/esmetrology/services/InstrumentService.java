package com.zaqueurodrigues.esmetrology.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zaqueurodrigues.esmetrology.dtos.instruments.InstrumentSaveDTO;
import com.zaqueurodrigues.esmetrology.dtos.instruments.InstrumentViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.entities.Instrument;
import com.zaqueurodrigues.esmetrology.entities.User;
import com.zaqueurodrigues.esmetrology.entities.enums.InstrumentStatus;
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

	public Page<InstrumentViewDTO> findAll(String tag, Long departmentId, String description, Pageable pageable) {

		User user = authService.authenticated();

		if (user != null && !user.hasRole("ROLE_ADMIN")) {

			Department department = departmentRepository.getById(user.getDepartment().getId());
			Page<Instrument> result = instrumentRepository.findByDepartment(department, pageable);
			return result.map(instrument -> new InstrumentViewDTO(instrument));
		}

		Department department = (departmentId == 0) ? null : departmentRepository.getById(departmentId);
		Page<Instrument> page = instrumentRepository.find(tag, department, description, pageable);
		instrumentRepository.findInstrumentWithDepartment(page.getContent());

		return page.map(inst -> new InstrumentViewDTO(inst));

	}
	
	public InstrumentViewDTO findById(Long id) {
		
		Optional<Instrument> opt = instrumentRepository.findById(id);

		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("Instrument not found!");
		}

		return new InstrumentViewDTO(opt.get());
		
	}
	
	public List<InstrumentViewDTO> findByDepartment(Long departmentId) {
		
		List<Instrument> instruments = instrumentRepository.findByDepartment(departmentRepository.getById(departmentId));
		
		return instruments.stream().map(i -> new InstrumentViewDTO(i)).collect(Collectors.toList());
		
	}

	public InstrumentViewDTO insert(InstrumentSaveDTO dto) {
		Instrument instrument = parseDtoToInstrument(dto);
		if(dto.getStatus() == null) {
			instrument.setStatus(InstrumentStatus.ACTIVE);
		}
		
		Optional<Department> departmentOp = departmentRepository.findById(dto.getDepartment().getId());

		if (!departmentOp.isPresent()) {
			throw new ResourceNotFoundException("Department not exists: " + dto.getDepartment().getId());
		}

		instrument.setDepartment(departmentOp.get());

		instrument = instrumentRepository.save(instrument);

		return new InstrumentViewDTO(instrument);

	}

	public InstrumentViewDTO update(Long id, InstrumentSaveDTO dto) {
		dto.setId(id);
		Optional<Department> departmentOp = departmentRepository.findById(dto.getDepartment().getId());

		if (!departmentOp.isPresent()) {
			throw new ResourceNotFoundException("Incorrect department id!");
		}
		var department = departmentOp.get();

		var instrument = instrumentRepository.getById(id);

		instrument = parseDtoToInstrument(dto);
		instrument.setDepartment(department);
		instrument = instrumentRepository.save(instrument);
		return new InstrumentViewDTO(instrument);

	}
	
	private Instrument parseDtoToInstrument(InstrumentSaveDTO dto) {
		
		return new Instrument(
				dto.getId(),
				dto.getTag(),
				dto.getSerie(),
				dto.getMark(),
				dto.getDescription(),
				dto.getType(),
				dto.getRange(),
				dto.getFrequency(),
				null, // lastCalibration
				dto.getStatus(),
				dto.getNote(),
				null, // department
				null ); // list certificates
				
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
