package com.eksad.minpro.dao;
import java.util.List;
import com.eksad.minpro.model.VariantModel;


public interface VariantDao {
	
	public List<VariantModel> getList();
	public VariantModel getByItemId(Integer itemId);
	public void insert(VariantModel model);

}
