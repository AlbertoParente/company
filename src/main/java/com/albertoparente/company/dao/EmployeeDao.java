package com.albertoparente.company.dao;

import java.util.List;
import com.albertoparente.company.domain.Employee;

public interface EmployeeDao {
	
	void save(Employee employee);
	
	void update(Employee employee);
	
	void delete(Long id);
	
	Employee findById(Long id);
	
	List<Employee> findAll();

	List<Employee> findByName(String name);

	List<Employee> findByOffice(Long id);
}
