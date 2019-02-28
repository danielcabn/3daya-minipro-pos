package com.eksad.minpro.dao;
import java.util.List;
import com.eksad.minpro.model.ItemModel;



public interface ItemDao {
	
	public List<ItemModel> getList();
	public void insert(ItemModel model);
	public List<ItemModel> search(String key);
	public void update(ItemModel model);
	public ItemModel getById(Integer id);
	
}
