package com.eksad.minpro.controller;

import java.util.List;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import com.eksad.minpro.service.EmployeeService;

@Controller
public class EmployeeController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/employee")
	public String index(Model model) {
		return "employee/index";
	}


	@RequestMapping(value = "/employee/create")
	public String create() {
		return "employee/create";
	}

	@RequestMapping(value = "/employee/insert")
	public String insert() {
		return "redirect:/employee";
	}


	
}
