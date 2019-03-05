package com.eksad.minpro.dao;
import java.util.List;
import com.eksad.minpro.model.InvenModel;


public interface InvenDao {
	
	public List<InvenModel> getList();
	public void insert(InvenModel model);
	public InvenModel getByvariantId(Integer variantId);

}
