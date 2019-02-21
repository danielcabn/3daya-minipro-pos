package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.SupplierModel;

public interface SupplierService {
	public List<SupplierModel> getList();
	public List<SupplierModel> search(String key);
	public SupplierModel getById(Integer id);
	public void insert(SupplierModel model);
	
}
