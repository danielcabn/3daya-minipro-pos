package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.EmployeeOutletDao;
import com.eksad.minpro.model.EmployeeOutletModel;
import com.eksad.minpro.service.EmployeeOutletService;


@Service
@Transactional
public class EmployeeOutletServiceImpl implements EmployeeOutletService {
	@Autowired
	private EmployeeOutletDao dao;

	@Override
	public List<EmployeeOutletModel> getList() {
		return this.dao.getList();
	}

	
	@Override
	public EmployeeOutletModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(EmployeeOutletModel model) {
		this.dao.insert(model);
	}

	
	
}
