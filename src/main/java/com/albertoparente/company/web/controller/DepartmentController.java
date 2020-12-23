package com.albertoparente.company.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salve(Department department, RedirectAttributes attr) {
		departmentService.save(department);
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/department/register";
	}
	
	@GetMapping("/edit/{id}")
	public String departmentBeforeEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("department", departmentService.findById(id));
		return "department/edit";
	}
	
	@PostMapping("/edit")
	public String departmentEdit(Department department, RedirectAttributes attr) {
		departmentService.update(department);
		attr.addFlashAttribute("success", "Departamento editado com sucesso.");
		return "redirect:/department/register";
	}
	
	@GetMapping("/delete/{id}")
	public String departmentDelete(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		if(!departmentService.departmentContainsOffice(id)) {
			model.addAttribute("fail","Falha ao remover. Departamento possui cargo(s) vinculado(s).");			 
		} else {
			departmentService.delete(id);
			attr.addFlashAttribute("success","Departamento excluído com sucesso.");	
		}
		return departmentList(model);
	}
}
