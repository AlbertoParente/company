package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.DepartmentDao;
import com.company.domain.Department;

@Service
@Transactional(readOnly = false)
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}

	@Override
	public void delete(Long id) {
		departmentDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Department findById(Long id) {
		return departmentDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
}
