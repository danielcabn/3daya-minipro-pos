package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.EmployeeDao;
import com.eksad.minpro.model.EmployeeModel;
import com.eksad.minpro.service.EmployeeService;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Override
	public List<EmployeeModel> getList() {
		return this.dao.getList();
	}

	
	@Override
	public EmployeeModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(EmployeeModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(EmployeeModel model) {
		this.dao.update(model);
	}
	
}
