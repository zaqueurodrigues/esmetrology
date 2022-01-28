package com.zaqueurodrigues.esmetrology.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaqueurodrigues.esmetrology.dtos.LabViewDTO;
import com.zaqueurodrigues.esmetrology.services.LabService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/labs")
@Api(tags = {"Labs"}, description = "API Lab")
public class LabResource {
	
	@Autowired
	private LabService labService;

	@GetMapping
	public ResponseEntity<Page<LabViewDTO>> findAll(Pageable pageable) {
		return ResponseEntity.ok(labService.findAll(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LabViewDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(labService.findById(id));
	}
}
