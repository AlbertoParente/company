/*
 * package com.company.models;
 * 
 * import java.io.Serializable; import java.math.BigDecimal; import
 * java.time.LocalDate;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
 * javax.persistence.OneToOne; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "EMPLOYEE") public class Employee implements Serializable{
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * @Id
 * 
 * @GeneratedValue(strategy= GenerationType.AUTO)
 * 
 * @Column(name = "EmployeeId") private long id;
 * 
 * @Column(name = "Name", unique = true, nullable = false) private String name;
 * 
 * @Column(name= "Salary", nullable = false, columnDefinition =
 * "DECIMAL (7,2) DEFAULT 0.00") private BigDecimal salary;
 * 
 * @Column(name = "AdmissionDate", nullable = false, columnDefinition = "DATE")
 * private LocalDate admissionDate;
 * 
 * @Column(name = "ResignationDate", columnDefinition = "DATE") private
 * LocalDate resignationDate;
 * 
 * @OneToOne(cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name = "Address_Id_fk") private Address address;
 * 
 * @ManyToOne(cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name = "Office_Id_fk") private Office office;
 * 
 * public long getId() { return id; }
 * 
 * public void setId(long id) { this.id = id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public BigDecimal getSalary() { return salary; }
 * 
 * public void setSalary(BigDecimal salary) { this.salary = salary; }
 * 
 * public LocalDate getAdmissionDate() { return admissionDate; }
 * 
 * public void setAdmissionDate(LocalDate admissionDate) { this.admissionDate =
 * admissionDate; }
 * 
 * public LocalDate getResignationDate() { return resignationDate; }
 * 
 * public void setResignationDate(LocalDate resignationDate) {
 * this.resignationDate = resignationDate; }
 * 
 * public Address getAddress() { return address; }
 * 
 * public void setAddress(Address address) { this.address = address; }
 * 
 * public Office getOffice() { return office; }
 * 
 * public void setOffice(Office office) { this.office = office; } }
 */