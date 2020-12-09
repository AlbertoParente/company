package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.OfficeDao;
import com.company.domain.Office;

@Service
@Transactional(readOnly = false)
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	private OfficeDao officeDao;
	
	@Override
	public void save(Office office) {
		officeDao.save(office);
	}

	@Override
	public void update(Office office) {
		officeDao.update(office);		
	}

	@Override
	public void delete(Long id) {
		officeDao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Office findById(Long id) {
		return officeDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Office> findAll() {
		return officeDao.findAll();
	}
}
