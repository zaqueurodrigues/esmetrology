package com.zaqueurodrigues.esmetrology.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaqueurodrigues.esmetrology.dtos.UserViewDTO;
import com.zaqueurodrigues.esmetrology.services.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/users")
@Api(tags = {"Users"}, description = "API User")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserViewDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}

}
