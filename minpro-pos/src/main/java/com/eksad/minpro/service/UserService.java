package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.UserModel;


public interface UserService {
	public List<UserModel> getList();
	public UserModel getById(Integer id);
	public void insert(UserModel model);

	
}
