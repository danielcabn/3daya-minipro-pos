package com.eksad.minpro.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eksad.minpro.service.OutletService;

@Controller
public class OutletController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private OutletService service;
	
	@RequestMapping(value = "/outlet")
	public String index(Model model) {
		return "outlet/index";
	}
	
	@RequestMapping(value = "/outlet/create")
	public String create() {
		return "outlet/create";
	}
	
	@RequestMapping(value = "/outlet/edit")
	public String edit() {
		return "outlet/edit";
	}
	
	
}
