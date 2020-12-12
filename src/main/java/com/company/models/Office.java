/*
 * package com.company.models;
 * 
 * import java.io.Serializable; import java.util.List;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne; import javax.persistence.OneToMany; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name= "OFFICE") public class Office implements Serializable {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * @Id
 * 
 * @GeneratedValue(strategy= GenerationType.AUTO)
 * 
 * @Column(name = "OfficeId") private Long id;
 * 
 * @Column(name = "Name", nullable = false, length = 60) private String name;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "Department_Id_fk") private Department department;
 * 
 * @OneToMany(mappedBy = "office") private List<Employee> employee;
 * 
 * public long getId() { return id; }
 * 
 * public void setId(long id) { this.id = id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public Department getDepartment() { return department; }
 * 
 * public void setDepartment(Department department) { this.department =
 * department; }
 * 
 * public List<Employee> getEmployee() { return employee; }
 * 
 * public void setEmployee(List<Employee> employee) { this.employee = employee;
 * } }
 */