package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.RoleModel;


public interface RoleService {
	public List<RoleModel> getList();
	public RoleModel getById(Integer id);
	

	
}