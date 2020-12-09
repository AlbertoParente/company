package com.company.dao;

import java.util.List;

import com.company.domain.Office;

public interface OfficeDao {
	
	void save(Office office);
	
	void update(Office office);
	
	void delete(Long id);
	
	Office findById(Long id);
	
	List<Office> findAll();
}
