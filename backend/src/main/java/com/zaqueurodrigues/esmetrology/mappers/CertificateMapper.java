package com.zaqueurodrigues.esmetrology.mappers;

import org.mapstruct.Mapper;

import com.zaqueurodrigues.esmetrology.dtos.CertificateViewDTO;
import com.zaqueurodrigues.esmetrology.entities.Certificate;

@Mapper(componentModel = "spring")
public interface CertificateMapper {

	CertificateViewDTO parseViewDTO(Certificate certificate);
	
	Certificate parseDepartment(CertificateViewDTO certificateViewDTO);
}
