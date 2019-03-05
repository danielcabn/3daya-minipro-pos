package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.TSModel;

public interface TSService {
	public List<TSModel> getList();
	public List<TSModel> getByIdTS(Integer id);
	public void insert(TSModel model);
}
