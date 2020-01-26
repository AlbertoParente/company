package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{

	Department findByCodigo(long id);
	
}

