package com.albertoparente.company.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.albertoparente.company.domain.Office;
import com.albertoparente.company.util.Pagination;

@Repository
public class OfficeDaoImpl extends AbstractDao<Office, Long> implements OfficeDao {

	public Pagination<Office> searchPaged(int page) {
		int size = 5;
		int start = (page - 1) * size;
		
		List<Office> offices = getEntityManager()
				.createQuery("select o from Office o order by o.name asc", Office.class)
				.setFirstResult(start)
				.setMaxResults(size)
				.getResultList();
		
		long totalRecords = count();
		long totalPages = (totalRecords + (size - 1)) / size;
		
		return new Pagination<>(size, page, totalPages, offices);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from Office", Long.class)
				.getSingleResult();
	}
}
