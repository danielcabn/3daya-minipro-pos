package com.eksad.minpro.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.minpro.model.RegionModel;
import com.eksad.minpro.service.RegionService;

@Controller
public class ApiRegionController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private RegionService service;
	
	@RequestMapping(value="/api/region/", method = RequestMethod.GET)
	public ResponseEntity<List<RegionModel>> list(){
		ResponseEntity<List<RegionModel>> result = null;
		try {
			List<RegionModel> list = this.service.getList();
			result = new ResponseEntity<List<RegionModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<List<RegionModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/region/id/{Rid}", method = RequestMethod.GET)
	public ResponseEntity<List<RegionModel>> searchRegion(@PathVariable("Rid") Long rid){
		ResponseEntity<List<RegionModel>> result = null;
		try {
			List<RegionModel> list = this.service.getByIdRegion(rid);
			result = new ResponseEntity<List<RegionModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<List<RegionModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}