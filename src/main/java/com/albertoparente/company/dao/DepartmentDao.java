package com.albertoparente.company.dao;

import java.util.List;
import com.albertoparente.company.domain.Department;

public interface DepartmentDao {
	
	void save(Department department);
	
	void update(Department department);
	
	void delete(Long id);
	
	Department findById(Long id);
	
	List<Department> findAll();
}
