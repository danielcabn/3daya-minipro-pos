package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.TSDao;
import com.eksad.minpro.model.TSModel;
import com.eksad.minpro.service.TSService;

@Service
@Transactional
public class TSServiceImpl implements TSService{
	@Autowired
	private TSDao dao;

	@Override
	public List<TSModel> getList() {
		return this.dao.getList();
	}

	@Override
	public List<TSModel> getByIdTS(Integer id) {
		return this.dao.getByIdTS(id);
	}

	@Override
	public void insert(TSModel model) {
		this.dao.insert(model);
		
	}
}
