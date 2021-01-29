package com.albertoparente.company.service;

import java.util.List;
import com.albertoparente.company.domain.Office;
import com.albertoparente.company.util.Pagination;

public interface OfficeService {

	void save(Office office);
	
	void update(Office office);
	
	void delete(Long id);
	
	Office findById(Long id);
	
	List<Office> findAll();
	
	boolean officeContainsEmployee(Long id);
	
	Pagination<Office> searchPaged(int page);
}
