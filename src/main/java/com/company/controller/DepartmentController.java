package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView departmentList() {
		ModelAndView mv = new ModelAndView("department/list");
		Iterable<Department> departments = departmentRepository.findAll();
		mv.addObject("departments", departments);
		return mv;
	}
	
	@PostMapping("/save")
	public String save(Department department) {
		departmentRepository.save(department);
		return "redirect:/department/register";
	}
}