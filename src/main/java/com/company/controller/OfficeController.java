package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.models.Office;
import com.company.repository.OfficeRepository;

@Controller
@RequestMapping("/office")
public class OfficeController {

	@Autowired
	private OfficeRepository officeRepository;
	
	@GetMapping("/register")
	public String officeRegister() {
		return "/office/register";
	}
	
	@GetMapping("/list")
	public ModelAndView officeList() {
		ModelAndView mv = new ModelAndView("office/list");
		Iterable<Office> office = officeRepository.findAll();
		mv.addObject("office", office);
		return mv;
	}
}