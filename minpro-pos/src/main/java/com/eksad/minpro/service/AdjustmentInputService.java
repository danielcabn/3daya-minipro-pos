package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.AdjustmentInputModel;

public interface AdjustmentInputService {
	public List<AdjustmentInputModel> getList();
	public AdjustmentInputModel getById(Integer id);
	public AdjustmentInputModel getBy(Integer adId);
	public void insert(AdjustmentInputModel model);
	public void update(AdjustmentInputModel model);
	public void delete(AdjustmentInputModel model);

}
