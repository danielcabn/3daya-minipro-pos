package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.RoleDao;
import com.eksad.minpro.model.RoleModel;
import com.eksad.minpro.service.RoleService;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao dao;

	@Override
	public List<RoleModel> getList() {
		return this.dao.getList();
	}

	
	@Override
	public RoleModel getById(Integer id) {
		return this.dao.getById(id);
	}

}
