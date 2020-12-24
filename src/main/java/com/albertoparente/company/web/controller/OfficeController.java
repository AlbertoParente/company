package com.albertoparente.company.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.albertoparente.company.domain.Department;
import com.albertoparente.company.domain.Office;
import com.albertoparente.company.service.DepartmentService;
import com.albertoparente.company.service.OfficeService;

@Controller
@RequestMapping("/office")
public class OfficeController {

	@Autowired
	private OfficeService officeService;
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/register")
	public String officeRegister(Office office) {
		return "/office/register";
	}
	
	@GetMapping("/list")
	public String officeList() {
		return "/office/list"; 
	}
	
	@PostMapping("/save")
	public String officeSave(Office office, RedirectAttributes attr) {
		officeService.save(office);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/office/register";
	}
	
	@ModelAttribute("departments")
	public List<Department>	listDepartment() {
		return departmentService.findAll();
	}
}