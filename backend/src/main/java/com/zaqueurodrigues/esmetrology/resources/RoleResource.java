package com.zaqueurodrigues.esmetrology.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaqueurodrigues.esmetrology.services.RoleService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value= "/roles")
@Api(tags = {"Roles"}, description = "API Role")
public class RoleResource {
	
	@Autowired
	private RoleService service;
	
	@GetMapping
	public ResponseEntity<List<?>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

}
