package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eksad.minpro.dao.VariantDao;
import com.eksad.minpro.model.VariantModel;
import com.eksad.minpro.service.VariantService;

@Service
@Transactional
public class VariantServiceImpl implements VariantService {
	
	@Autowired
	private VariantDao dao;
	
	@Override
	public void insert(VariantModel model) {
		this.dao.insert(model);
		
	}

	@Override
	public List<VariantModel> getList() {
		return this.dao.getList();
	}

	@Override
	public VariantModel getByItemId(Integer itemId) {
		// TODO Auto-generated method stub
		return this.dao.getByItemId(itemId);
	}

	@Override
	public String getNewSku() {
			return this.dao.getNewSku();
		}
	}


	
