package com.eksad.minpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PoController {
	
	@RequestMapping(value="/po")
	public String index() {		
		return "po/index";
	}
	
	@RequestMapping(value="/po/create")
	public String create() {
		return "po/create";
	}
	
	@RequestMapping(value="/po/edit")
	public String edit() {
		return "po/edit";
	}
	
	@RequestMapping(value="/po/detail")
	public String detail() {
		return "po/detail";
	}
}
