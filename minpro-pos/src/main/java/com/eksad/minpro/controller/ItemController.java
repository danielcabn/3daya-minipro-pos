package com.eksad.minpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.minpro.service.VariantService;


@Controller
public class ItemController {
	@Autowired
	private VariantService varservice;
	
	@RequestMapping(value = "/item")
	public String index() {
		return "item/index";
	}
	
	@RequestMapping(value="/item/create")
	public String create() {
		return "item/create";
	}
	
	@RequestMapping(value = "item/variant")
	public String addvar(Model model) {
		String code = this.varservice.getNewSku();
		model.addAttribute("KodeBaru", code);
		return "item/variant";
	}
	
	@RequestMapping(value="/itemvar/edit")
	public String edit() {
		return "item/edit";
	}
		
}	
