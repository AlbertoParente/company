package com.albertoparente.company.dao;

import java.util.List;
import com.albertoparente.company.domain.Department;
import com.albertoparente.company.util.Pagination;

public interface DepartmentDao {
	
	void save(Department department);
	
	void update(Department department);
	
	void delete(Long id);
	
	Department findById(Long id);
	
	List<Department> findAll();
	
	Pagination<Department> searchPaged(int page, String direction);
}
