package com.eksad.minpro.service;


import java.util.List;

import com.eksad.minpro.model.InvenModel;

public interface InvenService {
	public List<InvenModel> getList();
	public void insert(InvenModel model);
}
