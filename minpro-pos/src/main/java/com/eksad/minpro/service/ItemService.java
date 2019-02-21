package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.ItemModel;

public interface ItemService {
	
	public List<ItemModel> getList();

	public void insert(ItemModel item);
	
}