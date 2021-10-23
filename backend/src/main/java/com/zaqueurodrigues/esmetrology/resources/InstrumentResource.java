package com.zaqueurodrigues.esmetrology.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zaqueurodrigues.esmetrology.dtos.InstrumentSaveDTO;
import com.zaqueurodrigues.esmetrology.dtos.InstrumentViewDTO;
import com.zaqueurodrigues.esmetrology.services.InstrumentService;

@RestController
@RequestMapping(value = "/instruments")
public class InstrumentResource {
	
	@Autowired
	private InstrumentService service;
	
	@GetMapping
	public ResponseEntity<Page<InstrumentViewDTO>> findAll(
			@RequestParam(value = "tag", defaultValue = "") String tag,
			@RequestParam(value = "departmentId", defaultValue = "0") Long departmentId,
			@RequestParam(value = "description", defaultValue = "") String description,
			Pageable pageable
			){
		return ResponseEntity.ok(service.findAll(tag, departmentId, description, pageable));
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody InstrumentSaveDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{tag}").buildAndExpand(dto.getTag()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}

}
