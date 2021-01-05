package com.albertoparente.company.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.albertoparente.company.domain.Employee;
import com.albertoparente.company.domain.Office;
import com.albertoparente.company.domain.Uf;
import com.albertoparente.company.service.EmployeeService;
import com.albertoparente.company.service.OfficeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OfficeService officeService;
	
	@GetMapping("/register")
	public String employeeRegister(Employee employee) {
		return "/employee/register";
	}
	
	@GetMapping("/list")
	public String employeeList(ModelMap model) {
		model.addAttribute("employees", employeeService.findAll());
		return "/employee/list";
	}
	
	@PostMapping("/save")
	public String emplooyeeSave(Employee employee, RedirectAttributes attr) {
		employeeService.save(employee);
		attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
		return "redirect:/employee/register";
	}
	
	@GetMapping("/edit/{id}")
	public String employeeBeforeEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("employee", employeeService.findById(id));
		return "employee/register";
	}
	
	@PostMapping("/edit")
	public String employeeEdit(Employee employee, RedirectAttributes attr) {
		employeeService.update(employee);
		attr.addFlashAttribute("success", "Funcionario editado com sucesso.");
		return "redirect:/employee/register";
	}
	
	@GetMapping("/delete/{id}")
	public String employeeDelete(@PathVariable("id") Long id, RedirectAttributes attr) {
		employeeService.delete(id);
		attr.addFlashAttribute("success", "Funcionario excluído com sucesso.");
		return "redirect:/employee/list";
	}
	
	@ModelAttribute("offices")
	public List<Office>	getOffices() {
		return officeService.findAll();
	}
	
	@ModelAttribute("ufs")
	public Uf[] getUf() {
		return Uf.values();
	}
}
