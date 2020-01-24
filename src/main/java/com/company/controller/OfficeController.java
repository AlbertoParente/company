package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/office")
public class OfficeController {

	@GetMapping("/register")
	public String register() {
		return "/office/register";
	}
	
	@GetMapping("/officelist")
	public String departmentlist() {
		return "/office/list";
	}
}