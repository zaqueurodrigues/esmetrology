package com.zaqueurodrigues.esmetrology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EsmetrologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsmetrologyApplication.class, args);
	}

}
