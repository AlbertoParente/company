package com.company.dao;

import java.util.List;

import com.company.domain.Department;

public interface DepartmentDao {
	
	void save(Department department);
	
	void update(Department department);
	
	void delete(Long id);
	
	Department findById(Long id);
	
	List<Department> findAll();
}
