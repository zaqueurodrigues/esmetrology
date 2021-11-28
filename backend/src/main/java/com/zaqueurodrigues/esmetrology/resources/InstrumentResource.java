package com.zaqueurodrigues.esmetrology.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zaqueurodrigues.esmetrology.dtos.InstrumentSaveDTO;
import com.zaqueurodrigues.esmetrology.dtos.InstrumentViewDTO;
import com.zaqueurodrigues.esmetrology.services.InstrumentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/instruments")
@Api(tags = {"Instruments"}, description = "API Instrument")
public class InstrumentResource {
	
	@Autowired
	private InstrumentService service;
	
	@GetMapping
	@ApiOperation(value = "Get instruments")
	public ResponseEntity<Page<InstrumentViewDTO>> findAll(
			@RequestParam(value = "tag", defaultValue = "") String tag,
			@RequestParam(value = "departmentId", defaultValue = "0") Long departmentId,
			@RequestParam(value = "description", defaultValue = "") String description,
			Pageable pageable
			){
		return ResponseEntity.ok(service.findAll(tag, departmentId, description, pageable));
	}
	
	@PostMapping
	@ApiOperation(value = "Post instruments")
	public ResponseEntity<?> insert(@RequestBody @Valid InstrumentSaveDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{tag}").buildAndExpand(dto.getTag()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Put instruments")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody InstrumentSaveDTO dto) {
		var result = service.update(id, dto);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Delete instruments")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
