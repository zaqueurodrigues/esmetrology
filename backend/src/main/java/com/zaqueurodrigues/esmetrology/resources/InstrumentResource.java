package com.zaqueurodrigues.esmetrology.resources;

import java.net.URI;
import java.util.List;

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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/instruments")
@Api(tags = {"Instrumentos"})
public class InstrumentResource {
	
	@Autowired
	private InstrumentService service;
	
	@GetMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna uma lista pagina de instrumentos"),
	})
	@ApiOperation ("Busca todos os instrumentos")
	public ResponseEntity<Page<InstrumentViewDTO>> findAll(
			@RequestParam(value = "tag", defaultValue = "") String tag,
			@RequestParam(value = "departmentId", defaultValue = "0") Long departmentId,
			@RequestParam(value = "description", defaultValue = "") String description,
			Pageable pageable
			){
		return ResponseEntity.ok(service.findAll(tag, departmentId, description, pageable));
	}
	
	
	@GetMapping (value = "{/id}")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um instrumento"),
	})
	@ApiOperation ("Busca um instrumento por id")
	public ResponseEntity<InstrumentViewDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	
	@GetMapping (value = "/department/{id}")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna uma lista de instrumentos de um departamento"),
	})
	@ApiOperation ("Busca instrumentos de um departamento")
	public ResponseEntity<List<InstrumentViewDTO>> findByDepartment(@PathVariable Long departmentId) {
		
		return ResponseEntity.ok(service.findByDepartment(departmentId));
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody @Valid InstrumentSaveDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{tag}").buildAndExpand(dto.getTag()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody InstrumentSaveDTO dto) {
		var result = service.update(id, dto);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
