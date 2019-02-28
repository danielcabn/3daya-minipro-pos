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

import com.eksad.minpro.model.PoModel;
import com.eksad.minpro.service.PoService;

@Controller
public class ApiPoController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PoService service;
	
	@RequestMapping(value="/po/index")
	public String index(Model model){
		List<PoModel> list = this.service.getList();
		model.addAttribute("list",list);
		return "/po/index";
	}
	
	@RequestMapping(value="/api/po/", method=RequestMethod.GET)
	public ResponseEntity<List<PoModel>> list(){
		ResponseEntity<List<PoModel>> result = null;
		try {
			List<PoModel> list = this.service.getList();
			result = new ResponseEntity<List<PoModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<PoModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/po/search/{tglAwal}/{tglAkhir}/{status}/{poNo}",method=RequestMethod.GET)
	public ResponseEntity<List<PoModel>> search(@PathVariable("tglAwal") String tglAwal, @PathVariable("tglAkhir") String tglAkhir,
			@PathVariable("status") String status, @PathVariable("poNo") String poNo){
		ResponseEntity<List<PoModel>> result = null;
		try {
			List<PoModel> list = this.service.search(tglAwal, tglAkhir, status, poNo);
			result = new ResponseEntity<List<PoModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<PoModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/po/{catId}",method=RequestMethod.GET)
	public ResponseEntity<PoModel> getById(@PathVariable("catId") Long vId){
		ResponseEntity<PoModel> result = null;
		try {
			PoModel cat = this.service.getById(vId);
			result = new ResponseEntity<PoModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<PoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/po/status/{catId}/{status}",method=RequestMethod.POST)
	public ResponseEntity<PoModel> setStatus(@PathVariable("catId") Long vId, @PathVariable("status") String status){
		ResponseEntity<PoModel> result = null;
		try {
			PoModel cat = this.service.getById(vId);
			cat.setStatus(status);
			this.service.update(cat);
			result = new ResponseEntity<PoModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<PoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	
	@RequestMapping(value="/api/po/", method=RequestMethod.POST)
	public ResponseEntity<PoModel> postInsert(@RequestBody PoModel item){
		ResponseEntity<PoModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<PoModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<PoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/po/", method=RequestMethod.PUT)
	public ResponseEntity<PoModel> putUpdate(@RequestBody PoModel item){
		ResponseEntity<PoModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<PoModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<PoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
}