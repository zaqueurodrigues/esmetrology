package com.zaqueurodrigues.esmetrology.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long>{

	Page<Instrument> findByDepartment(Department department, Pageable pageable);
}