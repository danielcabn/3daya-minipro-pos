package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eksad.minpro.dao.InvenDao;
import com.eksad.minpro.model.InvenModel;
import com.eksad.minpro.service.InvenService;

@Service
@Transactional
public class InvenServiceImpl implements InvenService {
	
	@Autowired
	private InvenDao dao;
	
	@Override
	public void insert(InvenModel model) {
		this.dao.insert(model);
		
	}

	@Override
	public List<InvenModel> getList() {
		return this.dao.getList();
	}

	@Override
	public InvenModel getByvariantId(Integer variantId) {
		
		return this.dao.getByvariantId(variantId);
	}
}

	
