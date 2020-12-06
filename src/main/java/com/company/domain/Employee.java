package com.company.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.company.models.Address;
import com.company.models.Office;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE")
public abstract class Employee extends AbstractEntity<Long> {

	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name= "salary", nullable = false, columnDefinition = "DECIMAL (7,2) DEFAULT 0.00")
	private BigDecimal salary;
	
	@Column(name = "admission_date", nullable = false, columnDefinition = "DATE")
	private LocalDate admissionDate;
	
	@Column(name = "resignation_date", columnDefinition = "DATE")
	private LocalDate resignationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id_fk")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "office_id_fk")
	private Office office;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public LocalDate getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate(LocalDate resignationDate) {
		this.resignationDate = resignationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
}
