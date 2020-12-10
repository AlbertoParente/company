package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.EmployeeDao;
import com.company.domain.Employee;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Employee employee) {
		employeeDao.save(employee);		
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		employeeDao.delete(id);
		
	}

	@Override
	public Employee findById(Long id) {
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}	
}
