package com.eksad.minpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ItemController {
	
	@RequestMapping(value = "/item")
	public String index() {
		return "item/index";
	}
	
	@RequestMapping(value="/item/create")
	public String create() {
		return "item/create";
	}
	
	@RequestMapping(value = "item/variant")
	public String addvar() {
		return "item/variant";
	}
	
	@RequestMapping(value="/itemvar/edit")
	public String edit() {
		return "item/edit";
	}
	
	
}
