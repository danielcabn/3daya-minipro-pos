package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.DistrictDao;
import com.eksad.minpro.model.DistrictModel;
import com.eksad.minpro.service.DistrictService;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {
	@Autowired
	private DistrictDao disDao;
	
	@Override
	public List<DistrictModel> getList() {
		return this.disDao.getList();
	}

	@Override
	public List<DistrictModel> getByIdDistrict(Long id) {
		return this.disDao.getByIdDistrict(id);
	}

}
