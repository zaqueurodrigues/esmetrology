package com.zaqueurodrigues.esmetrology.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaqueurodrigues.esmetrology.dtos.InstrumentDTO;
import com.zaqueurodrigues.esmetrology.services.InstrumentService;

@RestController
@RequestMapping(value = "/instruments")
public class InstrumentResource {
	
	@Autowired
	private InstrumentService service;
	
	@GetMapping
	public ResponseEntity<Page<InstrumentDTO>> findAll(Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}

}
