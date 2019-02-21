package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.SupplierDao;
import com.eksad.minpro.model.SupplierModel;
import com.eksad.minpro.service.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierDao dao;

	@Override
	public List<SupplierModel> getList() {
		return this.dao.getList();
	}

	
	@Override
	public SupplierModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(SupplierModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(SupplierModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(SupplierModel model) {
		this.dao.delete(model);
	}


	@Override
	public List<SupplierModel> search(String key) {
		return this.dao.search(key);
	}
	
}
