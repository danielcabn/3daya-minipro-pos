package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.RegionDao;
import com.eksad.minpro.model.RegionModel;
import com.eksad.minpro.service.RegionService;


@Service
@Transactional
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegionDao dao;
	
	@Override
	public List<RegionModel> getList() {
		return this.dao.getList();
	}

	@Override
	public List<RegionModel> getByIdRegion(Long id) {
		return this.dao.getByIdRegion(id);
	}

}
