/*
 * package com.company.controller;
 * 
 * import java.lang.ProcessBuilder.Redirect;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.servlet.ModelAndView; import
 * org.springframework.web.servlet.mvc.support.RedirectAttributes;
 * 
 * import com.company.models.Department; import
 * com.company.repository.DepartmentRepository;
 * 
 * 
 * @Controller
 * 
 * @RequestMapping("/department") public class DepartmentController {
 * 
 * @Autowired private DepartmentRepository departmentRepository;
 * 
 * @GetMapping("/register") public String departmentRegister(Department
 * department) { return "/department/register"; }
 * 
 * @GetMapping("/list") public ModelAndView departmentList() { ModelAndView mv =
 * new ModelAndView("department/list"); Iterable<Department> departments =
 * departmentRepository.findAll(); mv.addObject("departments", departments);
 * return mv; }
 * 
 * @PostMapping("/save") public String save(Department department,
 * RedirectAttributes attr) { departmentRepository.save(department);
 * attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
 * return "redirect:/department/register"; }
 * 
 * @GetMapping("/edit/{id}") public String departmentPreEdit(@PathVariable("id")
 * Long id , ModelMap model) { departmentRepository.findById(id).ifPresent(o ->
 * model.addAttribute("department", o)); //model.addAttribute("department",
 * departmentRepository.findById(id)); return "/department/edit"; }
 * 
 * @PostMapping("/edit") public String departmentEdit(Department department,
 * RedirectAttributes attr) { departmentRepository.save(department);
 * attr.addFlashAttribute("success", "Departamento editado com sucesso.");
 * return "redirect:/department/list"; }
 * 
 * @GetMapping("/delete/{id}") public String delete(@PathVariable("id") Long id,
 * ModelMap model, RedirectAttributes attr) { if(departmentContainsOffice(id)) {
 * model.addAttribute(
 * "fail","Falha ao remover. Departamento possui cargo(s) vinculado(s)."); }
 * else { departmentRepository.deleteById(id);
 * attr.addFlashAttribute("success","Departamento excluído com sucesso."); }
 * return "redirect:/department/list"; }
 * 
 * public boolean departmentContainsOffice(Long id) {
 * if(departmentRepository.findById(id).get().getOffices().isEmpty()) { return
 * false; } return true; } }
 */