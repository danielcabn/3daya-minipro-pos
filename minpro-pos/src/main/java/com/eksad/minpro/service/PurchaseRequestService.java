package com.eksad.minpro.service;

import java.util.List;


import com.eksad.minpro.model.PurchaseRequestModel;

public interface PurchaseRequestService {
	public List<PurchaseRequestModel> getList();
	public PurchaseRequestModel getById(Integer id);
	public String getNewCode();
	public void insert(PurchaseRequestModel model);
	
	
}
