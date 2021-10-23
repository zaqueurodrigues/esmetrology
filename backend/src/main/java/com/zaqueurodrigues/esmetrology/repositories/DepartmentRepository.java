package com.zaqueurodrigues.esmetrology.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaqueurodrigues.esmetrology.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	Optional<Department> findByName(String name);
}
