			package com.eksad.minpro.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.minpro.model.EmployeeForm;
import com.eksad.minpro.model.EmployeeModel;
import com.eksad.minpro.service.EmployeeOutletService;
import com.eksad.minpro.service.EmployeeService;




@Controller
public class ApiEmployeeController {

	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private EmployeeService service;
	@Autowired
	private EmployeeOutletService service2;
	
	@RequestMapping(value="/api/employee/", method=RequestMethod.GET)
	public ResponseEntity<List<EmployeeModel>> list(){
		ResponseEntity<List<EmployeeModel>> result = null;
		try {
			List<EmployeeModel> list = this.service.getList();
			result = new ResponseEntity<List<EmployeeModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	} 
	
	
	@RequestMapping(value="/api/employee/{catId}")
	public ResponseEntity<EmployeeModel> getById (@PathVariable("catId")int vId){
		ResponseEntity<EmployeeModel> result=null;
		try {
			EmployeeModel cat = this.service.getById(vId);
			result = new ResponseEntity<EmployeeModel>(cat, HttpStatus.OK);
			
					
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	@RequestMapping (value="api/employee/", method=RequestMethod.POST)
	public ResponseEntity<EmployeeForm> postInsert(@RequestBody EmployeeForm item){
		ResponseEntity<EmployeeForm> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<EmployeeForm>(item, HttpStatus.CREATED);
			
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<EmployeeForm>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result; 
	}
 	
	
	@RequestMapping(value="/api/employee/edit", method=RequestMethod.PUT)
	public ResponseEntity<EmployeeModel> putUpdate(@RequestBody EmployeeModel item){
		ResponseEntity<EmployeeModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<EmployeeModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<EmployeeModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/employee/delete", method=RequestMethod.PUT)
	public ResponseEntity<EmployeeModel> putDelete(@RequestBody EmployeeModel item){
		ResponseEntity<EmployeeModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<EmployeeModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<EmployeeModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
