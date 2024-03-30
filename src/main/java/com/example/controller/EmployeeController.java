package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Repository.EmployeeRepository;
import com.example.entity.Employee;

@Controller
@RequestMapping("/employeeman")
public class EmployeeController {
	@Autowired
	private EmployeeRepository emprep;

	@GetMapping("/signup")
	public String showSignupForm(Employee emp) {
		return "add-employee";
	}

	@GetMapping("/list")
	public String showUpdateForm(Model model) {
		model.addAttribute("employees", emprep.findAll());
		return "index";
	}

	@PostMapping("/add")
	public String addEmployee(Employee emp, BindingResult result, Model model) {
		if (result.hasErrors())
			return "add-employee";
		emprep.save(emp);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable int id, Model model) {
		Employee emp = emprep.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee id: " + id));
		model.addAttribute("employee", emp);
		return "update-employee";
	}

	@PostMapping("/update/{id}")
	public String updateEmployee(@PathVariable int id, Employee emp, BindingResult result, Model model) {
		if (result.hasErrors()) {
			emp.setId(id);
			return "update-employee";
		}
		emprep.save(emp);
		return "redirect:/employeeman/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteTutorial(@PathVariable int id, Model model) {
		Employee emp = emprep.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee id: " + id));
		emprep.delete(emp);
		return "redirect:/employeeman/list";
	}
}
