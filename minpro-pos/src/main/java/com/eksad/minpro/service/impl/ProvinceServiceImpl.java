package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.ProvinceDao;
import com.eksad.minpro.model.ProvinceModel;
import com.eksad.minpro.service.ProvinceService;


@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceDao dao;

	@Override
	public List<ProvinceModel> getList() {
		return this.dao.getList();
	}

}
