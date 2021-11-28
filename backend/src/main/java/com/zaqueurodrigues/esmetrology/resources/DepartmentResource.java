package com.zaqueurodrigues.esmetrology.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaqueurodrigues.esmetrology.services.DepartmentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/departments")
@Api(tags = {"Departments"}, description = "API Department")
public class DepartmentResource {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public ResponseEntity<?> findDepartment(@RequestParam String name){
		return ResponseEntity.ok().body(departmentService.findByDepartmentName(name));
	}
}
