package com.albertoparente.company.service;

import java.util.List;
import com.albertoparente.company.domain.Department;
import com.albertoparente.company.util.Pagination;

public interface DepartmentService {
	
	void save(Department department);
	
	void update(Department department);
	
	void delete(Long id);
	
	Department findById(Long id);
	
	List<Department> findAll();

	boolean departmentContainsOffice(Long id);
	
	Pagination<Department> searchPaged(int page, String direction);
}
