package com.company.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTMENTS")
public class Department extends AbstractEntity<Long> {
	
	@Column(name = "name", nullable = false, unique = true, length = 60)
	private String name;
	
	@OneToMany(mappedBy = "department")
	private List<Office> office; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Office> getOffice() {
		return office;
	}

	public void setOffice(List<Office> office) {
		this.office = office;
	}
}
