package com.albertoparente.company.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.albertoparente.company.dao.EmployeeDao;
import com.albertoparente.company.domain.Employee;

@Service
@Transactional(readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);		
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	@Override
	public void delete(Long id) {
		employeeDao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findById(Long id) {
		return employeeDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findByName(String name) {
		return employeeDao.findByName(name);
	}	
}