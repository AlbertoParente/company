package com.albertoparente.company.dao;

import java.util.List;

// import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.albertoparente.company.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {

	public List<Employee> findByName(String name) {
		/*
		TypedQuery<Employee> query = getEntityManager()
				.createQuery("Select e from EMPLOYEE e where e.name like :name", Employee.class);
		query.setParameter("name", name);
		return query.getResultList();
		*/
		return createQuery("select e from Employee e where e.name like concat('%', ?1, '%') ", name);
	}

	@Override
	public List<Employee> findByOffice(Long id) {
		return createQuery("select e from Employee e where e.office.id = ?1", id);
	}
	
}
