package com.albertoparente.company.web.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "office/register";
	}
	
	@GetMapping("/list")
	public String officeList(ModelMap model) {
		model.addAttribute("offices", officeService.findAll());
		return "office/list";
	}
	
	@PostMapping("/save")
	public String officeSave(@Valid Office office, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) return "office/register";
		
		officeService.save(office);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/office/register";
	}
	
	@GetMapping("/edit/{id}")
	public String officeBeforeEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("office", officeService.findById(id));
		return "office/register";
	}
	
	@PostMapping("/edit")
	public String departmentEdit(@Valid Office office, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) return "office/register";
		
		officeService.update(office);
		attr.addFlashAttribute("success", "Cargo editado com sucesso.");
		return "redirect:/office/register";
	}
	
	@GetMapping("/delete/{id}")
	public String officeDelete(@PathVariable("id") Long id, RedirectAttributes attr) {
		if(officeService.officeContainsEmployee(id)) {
			attr.addFlashAttribute("fail","Falha ao remover. Cargo possui funcionario(s) vinculado(s).");			 
		} else {
			officeService.delete(id);
			attr.addFlashAttribute("success","Cargo excluído com sucesso.");	
		}
		return "redirect:/office/register";
	}
	
	@ModelAttribute("departments")
	public List<Department>	listDepartment() {
		return departmentService.findAll();
	}
}
