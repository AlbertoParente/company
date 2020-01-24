package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping("/register")
	public String register() {
		return "/employee/register";
	}
	
	@GetMapping("/employeelist")
	public String departmentlist() {
		return "/employee/list";
	}
}