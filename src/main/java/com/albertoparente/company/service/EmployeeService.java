package com.albertoparente.company.service;

import java.time.LocalDate;
import java.util.List;
import com.albertoparente.company.domain.Employee;
// import com.albertoparente.company.util.Pagination;

public interface EmployeeService {

	void save(Employee employee);
	
	void update(Employee employee);
	
	void delete(Long id);
	
	Employee findById(Long id);
	
	List<Employee> findAll();

	List<Employee> findByName(String name);

	List<Employee> findByOffice(Long id);

	List<Employee> findByDate(LocalDate admissionDate, LocalDate resignationDate);
	
	/*Pagination<Employee> searchPaged(int page, String direction);*/
}
