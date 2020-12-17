package com.albertoparente.company.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "OFFICES")
public abstract class Office extends AbstractEntity<Long> {
	
	@Column(name = "name", nullable = false, unique = true, length = 60)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_department_fk")
	private Department department;
	
	@OneToMany(mappedBy = "office")
	private List<Employee> employee;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
}