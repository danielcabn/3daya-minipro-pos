package com.eksad.minpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.minpro.model.PurchaseRequestModel;
import com.eksad.minpro.service.PurchaseRequestService;

@Controller
public class PurchaseRequestController {
	@Autowired
	private PurchaseRequestService kode;

	@RequestMapping(value = "/purchaserequest")
	public String index(Model model) {
		return "purchaserequest/index";
	}
	
	@RequestMapping(value = "/purchaserequest/create")
	public String create(Model model) {
		String code = this.kode.getNewCode();
		model.addAttribute("KodeBaru", code);
		return "purchaserequest/create";
	}
	@RequestMapping(value = "/purchaserequest/additem")
	public String additem() {
		return "purchaserequest/additem";
	}


}
