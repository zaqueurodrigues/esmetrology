package com.zaqueurodrigues.esmetrology.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zaqueurodrigues.esmetrology.dtos.CertificateInsertDTO;
import com.zaqueurodrigues.esmetrology.dtos.CertificateViewDTO;
import com.zaqueurodrigues.esmetrology.services.CertificateService;

@RestController
@RequestMapping("/certificates")
public class CertificateResource {
	
	@Autowired
	private CertificateService certificateService;
	
	@PostMapping
	public ResponseEntity<CertificateViewDTO> insert(@RequestBody CertificateInsertDTO dto) {
		CertificateViewDTO result = certificateService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").buildAndExpand(dto.getCode()).toUri();
		return ResponseEntity.created(uri).body(result);
	}
}
