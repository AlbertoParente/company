package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.models.Department;
import com.company.repository.DepartmentRepository;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/register")
	public String departmentRegister(Department department) {
		return "/department/register";
	}
	
	@GetMapping("/list")
	public String departmentList() {
		return "/department/list";
	}
	
	@PostMapping("/save")
	public String save(Department department) {
		departmentRepository.save(department);
		return "redirect:/department/register";
	}
}