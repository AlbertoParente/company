package com.albertoparente.company.dao;

import org.springframework.stereotype.Repository;
import com.albertoparente.company.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {
	
}
