package com.albertoparente.company.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.albertoparente.company.dao.OfficeDao;
import com.albertoparente.company.domain.Office;
import com.albertoparente.company.util.Pagination;

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

	@Override
	public boolean officeContainsEmployee(Long id) {
		if(findById(id).getEmployees().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public Pagination<Office> searchPaged(int page) {
		return officeDao.searchPaged(page);
	}
}
