package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.OutletModel;

public interface OutletService {
	public List<OutletModel> getList();
	public OutletModel getById(Integer id);
	public void insert(OutletModel model);

}