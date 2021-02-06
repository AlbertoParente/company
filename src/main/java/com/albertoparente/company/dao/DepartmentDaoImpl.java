package com.albertoparente.company.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.albertoparente.company.domain.Department;
import com.albertoparente.company.util.Pagination;

@Repository
public class DepartmentDaoImpl extends AbstractDao<Department, Long> implements DepartmentDao {
	
	public Pagination<Department> searchPaged(int page, String direction) {
		int size = 5;
		int start = (page - 1) * size;
		
		List<Department> departments = getEntityManager()
				.createQuery("select o from Department o order by o.name " + direction, Department.class)
				.setFirstResult(start)
				.setMaxResults(size)
				.getResultList();
		
		long totalRecords = count();
		long totalPages = (totalRecords + (size - 1)) / size;
		
		return new Pagination<>(size, page, totalPages, direction, departments);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from Department", Long.class)
				.getSingleResult();
	}
}
