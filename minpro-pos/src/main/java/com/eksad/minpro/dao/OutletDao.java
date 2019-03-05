package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.OutletModel;

public interface OutletDao {
	public List<OutletModel> getList();
	public List<OutletModel> search(String key);
	public OutletModel getById(Integer id);
	public void insert(OutletModel model);
	public void update(OutletModel model);
}
