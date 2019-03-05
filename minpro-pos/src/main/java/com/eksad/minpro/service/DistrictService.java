package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.DistrictModel;

public interface DistrictService {
	public List<DistrictModel> getList();
	public List<DistrictModel> getByIdDistrict(Long id);
}
