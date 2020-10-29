package com.company.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "DepartmentId")
	private Long id;

	@Column(name = "Name", nullable = false, length = 60)
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Office> Offices;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Office> getOffices() {
		return Offices;
	}

	public void setOffices(List<Office> offices) {
		Offices = offices;
	}
}
