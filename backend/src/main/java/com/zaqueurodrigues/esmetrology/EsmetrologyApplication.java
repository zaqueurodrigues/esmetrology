package com.zaqueurodrigues.esmetrology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zaqueurodrigues.esmetrology.log.EsmetrologyLogger;

@SpringBootApplication
public class EsmetrologyApplication {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(EsmetrologyApplication.class, args);
		
		EsmetrologyLogger.info(EsmetrologyApplication.class, "teste", null);
		EsmetrologyLogger.error(EsmetrologyApplication.class, "teste", null);
		EsmetrologyLogger.debug(EsmetrologyApplication.class, "teste", null);
	}

}
