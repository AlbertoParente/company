package com.albertoparente.company.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albertoparente.company.domain.Department;
import com.albertoparente.company.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/register")
	public String departmentRegister(Department department) {
		return "/department/register";
	}
	
	@GetMapping("/list")
	public String departmentList(ModelMap model) {
		model.addAttribute("departments", departmentService.findAll());
		return "/department/list";
	}
	
	@PostMapping("/save")
	public String salve(Department department) {
		departmentService.save(department);
		return "redirect:/departments/register";
	}
	
	@GetMapping("/edit/{id}")
	public String departmentBeforeEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("department", departmentService.findById(id));
		return "department/register";
	}
	
	@PostMapping("/edit")
	public String edit(Department department) {
		departmentService.update(department);
		return "redirect:/department/register";
	}
}
