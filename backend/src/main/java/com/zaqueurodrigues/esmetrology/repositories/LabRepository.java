package com.zaqueurodrigues.esmetrology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaqueurodrigues.esmetrology.entities.Lab;

public interface LabRepository extends JpaRepository<Lab, Long>{
	
	Lab findByName(String name);

}
