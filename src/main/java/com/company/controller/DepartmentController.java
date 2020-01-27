package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.models.Department;
import com.company.repository.DepartmentRepository;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/register")
	public String register() {
		return "/department/register";
	}
	
	@GetMapping("/departmentlist")
	public String departmentlist() {
		return "/department/list";
	}
	
	@RequestMapping("/deletedepartment")
	public String deletarEvento(long id){
		Department department = departmentRepository.findById(id);
		departmentRepository.delete(department);		
		return "redirect:/department";
	}
	
	
}
