package com.zaqueurodrigues.esmetrology.services;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.zaqueurodrigues.esmetrology.repositories.DepartmentRepository;
import com.zaqueurodrigues.esmetrology.repositories.InstrumentRepository;
import com.zaqueurodrigues.esmetrology.services.exceptions.ResourceNotFoundException;

@Service
public class InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<InstrumentViewDTO> findAll(
				String tag, 
				Long departmentId, 
				String description,  
				Pageable pageable
			){
		
		User user = authService.authenticated();
		
		if(!user.hasRole("ROLE_ADMIN")) {
			
			Department department = departmentRepository.getById(user.getDepartment().getId());
			Page<Instrument> result = instrumentRepository.findByDepartment(department, pageable);
			return result.map(instrument -> InstrumentViewDTO.toInstrument(instrument));
		}
		
		Department department = (departmentId == 0) ? null : departmentRepository.getById(departmentId);
		Page<Instrument> page = instrumentRepository.find(tag, department, description, pageable);
		instrumentRepository.findInstrumentWithDepartment(page.getContent());
		
		return page.map(inst -> InstrumentViewDTO.toInstrument(inst));
		
	}
	
	@Transactional
	public InstrumentViewDTO insert(InstrumentSaveDTO dto){
		Instrument instrument = new Instrument();
		Department department = departmentRepository.getById(dto.getDepartmentId());
		
		if(department == null) {
			throw new ResourceNotFoundException("Department not exists: " +dto.getDepartmentId());
		}
		
		instrument = Instrument.builder()
				.tag(dto.getTag())
				.description(dto.getDescription())
				.type(dto.getType())
				.frequency(dto.getFrequency())
				.range(dto.getRange())
				.department(department)
				.status(InstrumentStatus.ACTIVE)
				.build();
		
		instrument = instrumentRepository.save(instrument);
		
		return InstrumentViewDTO.toInstrument(instrument);
		
	}
				
	
}
