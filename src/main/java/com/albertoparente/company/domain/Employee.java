package com.albertoparente.company.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends AbstractEntity<Long> {

	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name= "salary", nullable = false, columnDefinition = "DECIMAL (7,2) DEFAULT 0.00")
	private BigDecimal salary;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "admission_date", nullable = false, columnDefinition = "DATE")
	private LocalDate admissionDate;
	
	@DateTimeFormat(iso = ISO.DATE)
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