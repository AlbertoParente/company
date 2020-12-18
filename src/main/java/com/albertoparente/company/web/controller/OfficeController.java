package com.albertoparente.company.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/office")
public class OfficeController {

	@GetMapping("/register")
	public String officeRegister() {
		return "/office/register";
	}
	
	@GetMapping("/list")
	public String officeList() {
		return "/office/list"; 
	}
}