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

import com.eksad.minpro.model.ItemForm;
import com.eksad.minpro.model.ItemModel;
import com.eksad.minpro.model.VariantModel;
import com.eksad.minpro.service.ItemService;
import com.eksad.minpro.service.VariantService;


@Controller
public class ApiItemController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private ItemService service;
	
	@Autowired
	private VariantService varservice;
	
	@RequestMapping(value="/api/item", method=RequestMethod.GET)
	public ResponseEntity<List<ItemModel>> list(){
		log.debug("test");
		ResponseEntity<List<ItemModel>> result = null;
		try {
			List<ItemModel> list = this.service.getList();
			result = new ResponseEntity<List<ItemModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<ItemModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/item", method=RequestMethod.POST)
	public ResponseEntity<ItemForm> postInsert(@RequestBody ItemForm item){
		ResponseEntity<ItemForm> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<ItemForm>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<ItemForm>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/item", method=RequestMethod.PUT)
	public ResponseEntity<ItemModel> putUpdate(@RequestBody ItemModel item){
		ResponseEntity<ItemModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<ItemModel>(item, HttpStatus. ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<ItemModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/item/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<ItemModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<ItemModel>> result = null;
		try {
			List<ItemModel> list = this.service.search(cari);
			result = new ResponseEntity<List<ItemModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<ItemModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/item/{catId}",method=RequestMethod.GET)
	public ResponseEntity<ItemModel> getById(@PathVariable("catId") int vId){
		ResponseEntity<ItemModel> result = null;
		try {
			ItemModel cat = this.service.getById(vId);
			result = new ResponseEntity<ItemModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<ItemModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/itemVar/{catId}",method=RequestMethod.GET)
	public ResponseEntity<VariantModel> getByItemId(@PathVariable("catId") int vId){
		ResponseEntity<VariantModel> result = null;
		try {
			VariantModel cat = this.varservice.getByItemId(vId);
			result = new ResponseEntity<VariantModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<VariantModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
}
