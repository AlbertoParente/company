package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@GetMapping("/register")
	public String departmentRegister() {
		return "/department/register";
	}
	
	@GetMapping("/list")
	public String departmentList() {
		return "/department/list";
	}
}
