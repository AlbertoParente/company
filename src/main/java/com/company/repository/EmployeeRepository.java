package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

	Employee findById(long id);
}
