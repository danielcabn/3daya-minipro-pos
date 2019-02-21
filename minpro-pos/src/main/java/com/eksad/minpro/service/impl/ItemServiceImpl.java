package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.ItemDao;
import com.eksad.minpro.model.ItemModel;
import com.eksad.minpro.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao dao;
	
	@Override
	public List<ItemModel> getList() {
		return this.dao.getList();
	}

	@Override
	public void insert(ItemModel item) {
		this.dao.insert(item);
	}
	
	

}