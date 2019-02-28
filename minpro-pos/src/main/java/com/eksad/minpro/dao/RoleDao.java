package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.RoleModel;


public interface RoleDao {
	public List<RoleModel> getList();
	public RoleModel getById(Integer id);


}
