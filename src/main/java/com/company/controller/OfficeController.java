package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.models.Department;
import com.company.models.Office;
import com.company.repository.DepartmentRepository;
import com.company.repository.OfficeRepository;

@Controller
@RequestMapping("/office")
public class OfficeController  {

	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/register")
	public String officeRegister(Office office) {
		return "/office/register";
	}
	
	@GetMapping("/list")
	public ModelAndView officeList() {
		ModelAndView mv = new ModelAndView("office/list");
		Iterable<Office> office = officeRepository.findAll();
		mv.addObject("offices", office);
		return mv;
	}
	
	@PostMapping("/save")
	public String save(Office office, RedirectAttributes attr) {
		officeRepository.save(office);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/office/register";
	}
	
	@ModelAttribute("departments")
	public List<Department> departmentList() {
		return departmentRepository.findAll();
	}
	/*
	@Override
	public Department convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		long id = Long.valueOf(text);
		System.out.println(text);
		return departmentRepository.findById(id);
		
	}*/
}