package com.zaqueurodrigues.esmetrology.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		/*
		modelMapper.createTypeMap(Instrument.class, InstrumentDTO.class)
			.<String>addMapping(src -> src.getCertificates().get(src.getCertificates().size() - 1).getCode(), 
					(dest, value) -> {
						var lastCertificate = new CertificateDTO();
						lastCertificate.setCode(value);
					});
		
		*/
		return modelMapper; 
	}

}
