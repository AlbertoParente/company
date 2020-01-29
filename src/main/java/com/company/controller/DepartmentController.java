package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@GetMapping("/register")
	public String register() {
		return "/department/register";
	}
	
	@GetMapping("/departmentlist")
	public String departmentlist() {
		return "/department/list";
	}
}
