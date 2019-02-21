package com.eksad.minpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/employee")
	public String index(Model model) {
		return "employee/index";
	}

	@RequestMapping(value = "/employee/create")
	public String create() {
		return "employee/create";
	}

	@RequestMapping(value = "/employee/edit")
	public String edit() {
		return "employee/edit";
	}

}
