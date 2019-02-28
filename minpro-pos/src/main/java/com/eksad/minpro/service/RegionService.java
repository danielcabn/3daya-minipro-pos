package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.RegionModel;

public interface RegionService {
	public List<RegionModel> getList();
	public List<RegionModel> getByIdRegion(Long id);
}
