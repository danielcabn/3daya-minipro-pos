package com.eksad.minpro.service;


import java.util.List;

import com.eksad.minpro.model.VariantModel;

public interface VariantService {
	public List<VariantModel> getList();
	public VariantModel getByItemId(Integer itemId);
	public void insert(VariantModel model);
}
