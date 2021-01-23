package com.albertoparente.company.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTMENTS")
public class Department extends AbstractEntity<Long> {
	
	@NotBlank(message = "Informe um nome!")
	@Size(min= 3, max = 60, message = "O nome do departamento deve ter entre {min} e {max} caracteres!")
	@Column(name = "name", nullable = false, unique = true, length = 60)
	private String name;
	
	@OneToMany(mappedBy = "department")
	private List<Office> offices; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Office> getOffices() {
		return offices;
	}

	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}
}
