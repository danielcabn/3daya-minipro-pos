package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.RegionModel;

public interface RegionDao {
	public List<RegionModel> getList();
	public List<RegionModel> getByIdRegion(Long id);

}
