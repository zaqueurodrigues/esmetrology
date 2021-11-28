package com.zaqueurodrigues.esmetrology.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zaqueurodrigues.esmetrology.dtos.DepartmentViewDTO;
import com.zaqueurodrigues.esmetrology.services.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/departments")
@Api(tags = {"Departments"}, description = "API Department")
public class DepartmentResource {
	
	@Autowired
	private DepartmentService service;
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get departments")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findByid(id));
	}
	
	@PostMapping
	@ApiOperation(value = "Post instruments")
	public ResponseEntity<?> insert(@RequestBody @Valid DepartmentViewDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Put departments")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DepartmentViewDTO dto) {
		var result = service.update(id, dto);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Delete departments")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
