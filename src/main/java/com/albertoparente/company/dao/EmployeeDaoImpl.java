package com.albertoparente.company.dao;

import java.time.LocalDate;
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

	@Override
	public List<Employee> findByAdmissionDateResignationDate(LocalDate admissionDate, LocalDate resignationDate) {
		String jpql = new StringBuilder("select e from Employee e ")
				.append("where e.admissionDate >= ?1 and e.resignationDate <= ?2")
				.append("order by e.admissionDate asc")
				.toString();
		return createQuery(jpql, admissionDate, resignationDate);
	}

	@Override
	public List<Employee> findByAdmissionDate(LocalDate admissionDate) {
		String jpql = new StringBuilder("select e from Employee e ")
				.append("where e.admissionDate = ?1 ")
				.append("order by e.admissionDate asc")
				.toString();
		return createQuery(jpql, admissionDate);
	}

	@Override
	public List<Employee> findByResignationDate(LocalDate resignationDate) {
		String jpql = new StringBuilder("select e from Employee e ")
				.append("where e.resignationDate = ?1 ")
				.append("order by e.admissionDate asc")
				.toString();
		return createQuery(jpql, resignationDate);
	}
	
}
