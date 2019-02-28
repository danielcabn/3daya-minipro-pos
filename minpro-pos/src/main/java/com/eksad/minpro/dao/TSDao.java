package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.TSModel;

public interface TSDao {
	public List<TSModel> getList();
	public List<TSModel> getByIdTS(Integer id);
	public void insert(TSModel model);
}
