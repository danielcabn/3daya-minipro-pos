package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.UserDao;
import com.eksad.minpro.model.UserModel;
import com.eksad.minpro.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public List<UserModel> getList() {
		return this.dao.getList();
	}

	
	@Override
	public UserModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(UserModel model) {
		this.dao.insert(model);
	}


}
