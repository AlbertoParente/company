package com.albertoparente.company.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.albertoparente.company.domain.Employee;
import com.albertoparente.company.domain.Office;
import com.albertoparente.company.domain.Uf;
import com.albertoparente.company.service.EmployeeService;
import com.albertoparente.company.service.OfficeService;
import com.albertoparente.company.web.validator.EmployeeValidator;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OfficeService officeService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new EmployeeValidator());
	}
	
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
	public String emplooyeeSave(@Valid Employee employee, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) return "/employee/register";
		
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
	public String employeeEdit(@Valid Employee employee, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) return "/employee/register";
		
		employeeService.update(employee);
		attr.addFlashAttribute("success", "Funcionario editado com sucesso.");
		return "redirect:/employee/list";
	}
	
	@GetMapping("/delete/{id}")
	public String employeeDelete(@PathVariable("id") Long id, RedirectAttributes attr) {
		employeeService.delete(id);
		attr.addFlashAttribute("success", "Funcionario excluído com sucesso.");
		return "redirect:/employee/list";
	}
	
	@GetMapping("/search/name")
	public String searchForName(@RequestParam("name") String name, ModelMap model) {
		model.addAttribute("employees", employeeService.findByName(name));
		return "/employee/list";
	}
	
	@GetMapping("/search/office")
	public String searchForOffice(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("employees", employeeService.findByOffice(id));
		return "/employee/list";
	}
	
	@GetMapping("/search/date")
	public String searchForDate(@RequestParam(name = "admissionDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate admissionDate, 
			                    @RequestParam(name = "resignationDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate resignationDate, 
			                    ModelMap model) {
		model.addAttribute("employees", employeeService.findByDate(admissionDate, resignationDate));
		return "/employee/list";
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
