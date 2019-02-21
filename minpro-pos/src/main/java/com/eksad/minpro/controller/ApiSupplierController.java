package com.eksad.minpro.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.minpro.model.SupplierModel;
import com.eksad.minpro.service.SupplierService;

@Controller
public class ApiSupplierController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private SupplierService service;
	
	@RequestMapping(value="/supplier/index")
	public String index(Model model){
		List<SupplierModel> list = this.service.getList();
		model.addAttribute("list",list);
		return "/supplier/index";
	}
	
	@RequestMapping(value="/api/supplier/", method=RequestMethod.GET)
	public ResponseEntity<List<SupplierModel>> list(){
		ResponseEntity<List<SupplierModel>> result = null;
		try {
			List<SupplierModel> list = this.service.getList();
			result = new ResponseEntity<List<SupplierModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<SupplierModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/supplier/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<SupplierModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<SupplierModel>> result = null;
		try {
			List<SupplierModel> list = this.service.search(cari);
			result = new ResponseEntity<List<SupplierModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<SupplierModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/supplier/{catId}",method=RequestMethod.GET)
	public ResponseEntity<SupplierModel> getById(@PathVariable("catId") int vId){
		ResponseEntity<SupplierModel> result = null;
		try {
			SupplierModel cat = this.service.getById(vId);
			result = new ResponseEntity<SupplierModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<SupplierModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/supplier/", method=RequestMethod.POST)
	public ResponseEntity<SupplierModel> postInsert(@RequestBody SupplierModel item){
		ResponseEntity<SupplierModel> result = null;
		try {
			item.setActive(true);
			this.service.insert(item);
			result = new ResponseEntity<SupplierModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<SupplierModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
}