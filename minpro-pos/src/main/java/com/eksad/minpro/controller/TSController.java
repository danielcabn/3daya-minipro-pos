package com.eksad.minpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TSController {
	
	@RequestMapping(value = "/ts")
	public String index(Model model) {
		return "ts/index";
	}
	
	@RequestMapping(value="/ts/create")
	public String create() {
		return "ts/create";
	}
	
	@RequestMapping(value="/ts/item")
	public String createItem() {
		return "ts/add-item";
	}
}
