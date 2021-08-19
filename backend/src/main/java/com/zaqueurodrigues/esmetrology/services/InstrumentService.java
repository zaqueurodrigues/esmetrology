package com.zaqueurodrigues.esmetrology.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaqueurodrigues.esmetrology.dtos.InstrumentDTO;
import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.entities.Instrument;
import com.zaqueurodrigues.esmetrology.entities.User;
import com.zaqueurodrigues.esmetrology.repositories.DepartmentRepository;
import com.zaqueurodrigues.esmetrology.repositories.InstrumentRepository;

@Service
public class InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<InstrumentDTO> findAll(Pageable pageable){
		
		User user = authService.authenticated();
		
		if(!user.hasRole("ROLE_ADMIN")) {
			
			Department department = departmentRepository.getById(user.getDepartment().getId());
			
			Page<Instrument> result = instrumentRepository.findByDepartment(department, pageable);
			return result.map(instrument -> new InstrumentDTO(instrument));
		}
		
		return instrumentRepository.findAll(pageable).map(instrument -> new InstrumentDTO(instrument));
	}
}
