package com.eksad.minpro.service;

import java.util.List;


import com.eksad.minpro.model.ItemModel;
import com.eksad.minpro.model.ItemForm;

public interface ItemService {
	
	public List<ItemModel> getList();
	public List<ItemModel> search(String key);
	public void insert(ItemForm model);
	public void update(ItemModel item);
	public ItemModel getById(Integer id);

}
