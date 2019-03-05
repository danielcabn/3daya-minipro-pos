package com.eksad.minpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.minpro.model.DistrictModel;
import com.eksad.minpro.service.DistrictService;

@Controller
public class ApiDistrictController {
	
	@Autowired
	private DistrictService disService;
	
	@RequestMapping(value = "/api/district/", method = RequestMethod.GET)
	public ResponseEntity<List<DistrictModel>> districtList() {
		ResponseEntity<List<DistrictModel>> result = null;
		try {
			List<DistrictModel> list = this.disService.getList();
			result = new ResponseEntity<List<DistrictModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity<List<DistrictModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value = "/api/district/id/{Did}", method = RequestMethod.GET)
	public ResponseEntity<List<DistrictModel>> searchDistrict(@PathVariable("Did") Long did) {
		ResponseEntity<List<DistrictModel>> result = null;
		try {
			List<DistrictModel> list = this.disService.getByIdDistrict(did);
			result = new ResponseEntity<List<DistrictModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity<List<DistrictModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

}