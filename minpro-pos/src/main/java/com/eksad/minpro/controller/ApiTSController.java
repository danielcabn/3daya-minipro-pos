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

import com.eksad.minpro.model.OutletModel;
import com.eksad.minpro.model.RegionModel;
import com.eksad.minpro.model.TSModel;
import com.eksad.minpro.service.TSService;

@Controller
public class ApiTSController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private TSService service;
	
	@RequestMapping(value="/api/ts/", method = RequestMethod.GET)
	public ResponseEntity<List<TSModel>> list(){
		ResponseEntity<List<TSModel>> result = null;
		try {
			List<TSModel> list = this.service.getList();
			result = new ResponseEntity<List<TSModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/ts/id/{Rid}", method = RequestMethod.GET)
	public ResponseEntity<List<TSModel>> searchTS(@PathVariable("Rid") Integer rid){
		ResponseEntity<List<TSModel>> result = null;
		try {
			List<TSModel> list = this.service.getByIdTS(rid);
			result = new ResponseEntity<List<TSModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/ts/", method=RequestMethod.POST)
	public ResponseEntity<TSModel> postInsert(@RequestBody TSModel item){
		ResponseEntity<TSModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<TSModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<TSModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
