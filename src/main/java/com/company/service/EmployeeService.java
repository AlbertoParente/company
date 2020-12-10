package com.company.service;

import java.util.List;

import com.company.domain.Employee;


public interface EmployeeService {

	void save(Employee employee);
	
	void update(Employee employee);
	
	void delete(Long id);
	
	Employee findById(Long id);
	
	List<Employee> findAll();
}
