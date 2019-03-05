package com.eksad.minpro.dao;

import java.util.List;


import com.eksad.minpro.model.PurchaseRequestModel;


public interface PurchaseRequestDao {
	public List<PurchaseRequestModel> getList();
	public PurchaseRequestModel getById(Integer id);
	public void insert(PurchaseRequestModel model);
	public String getNewCode();	
}
