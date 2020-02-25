package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Department findById(long id);
	
	public static boolean departmentContainsOffice(Long id) {
		Department department = new Department();
		if(department.getOffices().isEmpty()) {
			return false;
		}
		return true;
	}
}