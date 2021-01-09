package com.albertoparente.company.dao;

import java.time.LocalDate;
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

	List<Employee> findByAdmissionDateResignationDate(LocalDate admissionDate, LocalDate resignationDate);

	List<Employee> findByAdmissionDate(LocalDate admissionDate);

	List<Employee> findByResignationDate(LocalDate resignationDate);
}
