package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.UserModel;


public interface UserDao {
	public List<UserModel> getList();
	public UserModel getById(Integer id);
	public void insert(UserModel model);


}
