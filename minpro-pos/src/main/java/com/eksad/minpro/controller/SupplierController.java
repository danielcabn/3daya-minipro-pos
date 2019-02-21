package com.eksad.minpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplierController {
	
	@RequestMapping(value="/supplier")
	public String index() {		
		return "supplier/index";
	}
	
	@RequestMapping(value="/supplier/detail")
	public String detail() {	
		return "supplier/detail";
	}
	
	@RequestMapping(value="/supplier/create")
	public String create() {
		return "supplier/create";
	}
	
	@RequestMapping(value="/supplier/edit")
	public String edit() {
		return "supplier/edit";
	}
	
	@RequestMapping(value="/supplier/delete")
	public String delete() {
		return "supplier/delete";
	}
	
}
