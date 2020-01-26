package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.models.Office;

public interface OfficeRepository extends JpaRepository<Office, Long>{
	
	Office findById(long id);
}