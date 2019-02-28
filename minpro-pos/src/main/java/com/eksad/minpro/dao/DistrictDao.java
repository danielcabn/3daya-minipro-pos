package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.DistrictModel;

public interface DistrictDao {
	public List<DistrictModel> getList();
	public List<DistrictModel> getByIdDistrict(Long id);
}
