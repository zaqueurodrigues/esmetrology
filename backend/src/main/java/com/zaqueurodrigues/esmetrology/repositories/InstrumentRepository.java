package com.zaqueurodrigues.esmetrology.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zaqueurodrigues.esmetrology.entities.Department;
import com.zaqueurodrigues.esmetrology.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long>{

	List<Instrument> findByDepartment(Department department);
	
	Page<Instrument> findByDepartment(Department department, Pageable pageable);
	
	@Query("SELECT DISTINCT obj FROM Instrument obj JOIN obj.department dep WHERE "
			+ "(COALESCE(:department) IS null or dep IN :department) AND "
			+ "(LOWER(obj.description) LIKE LOWER(CONCAT ('%', :description, '%')) ) AND "
			+ "(LOWER(obj.tag) LIKE LOWER(CONCAT ('%', :tag, '%')) )")
	Page<Instrument> find(String tag, Department department, String description, Pageable pageable);
	
	@Query("SELECT obj FROM Instrument obj JOIN FETCH obj.department WHERE obj IN :instruments")
	List<Instrument> findInstrumentWithDepartment(List<Instrument> instruments);
	
}
