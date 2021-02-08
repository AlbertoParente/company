package com.albertoparente.company.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.albertoparente.company.dao.EmployeeDao;
import com.albertoparente.company.domain.Employee;
// import com.albertoparente.company.util.Pagination;

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

	@Override
	public List<Employee> findByOffice(Long id) {
		return employeeDao.findByOffice(id);
	}

	@Override
	public List<Employee> findByDate(LocalDate admissionDate, LocalDate resignationDate) {
		if(admissionDate != null && resignationDate != null ) {
			return employeeDao.findByAdmissionDateResignationDate(admissionDate, resignationDate);
		} else if (admissionDate != null) {
			return employeeDao.findByAdmissionDate(admissionDate);
		} else if (resignationDate != null) {
			return employeeDao.findByResignationDate(resignationDate);
		} else {
			return new ArrayList<>();
		}
	}
	/*
	@Override
	public Pagination<Employee> searchPaged(int page, String direction) {
		return employeeDao.searchPaged(page, direction);
	}*/
}
