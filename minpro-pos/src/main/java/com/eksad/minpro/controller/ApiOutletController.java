package com.eksad.minpro.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.minpro.model.OutletModel;
import com.eksad.minpro.service.OutletService;

@Controller
public class ApiOutletController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private OutletService service;
	
	@RequestMapping(value="/api/outlet/", method = RequestMethod.GET)
	public ResponseEntity<List<OutletModel>> list(){
		ResponseEntity<List<OutletModel>> result = null;
		try {
			List<OutletModel> list = this.service.getList();
			result = new ResponseEntity<List<OutletModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/outlet/",method = RequestMethod.POST)
	public ResponseEntity<OutletModel> postInsert(@RequestBody OutletModel item){
		ResponseEntity<OutletModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<OutletModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<OutletModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	
}
