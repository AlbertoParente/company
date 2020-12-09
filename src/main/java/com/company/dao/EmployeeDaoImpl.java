package com.company.dao;

import org.springframework.stereotype.Repository;

import com.company.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {
	
}
