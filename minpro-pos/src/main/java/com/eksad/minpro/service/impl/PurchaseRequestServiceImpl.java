package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.PurchaseRequestDao;
import com.eksad.minpro.model.PurchaseRequestModel;
import com.eksad.minpro.service.PurchaseRequestService;


@Service
@Transactional
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
	@Autowired
	private PurchaseRequestDao dao;

	@Override
	public List<PurchaseRequestModel> getList() {
		return this.dao.getList();
	}

	
	@Override
	public PurchaseRequestModel getById(Integer id) {
		return this.dao.getById(id);
	}
	@Override
	public void insert(PurchaseRequestModel model) {
		this.dao.insert(model);
	}
	@Override
	public String getNewCode() {
		return this.dao.getNewCode();
	}
	
}
