package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.EmployeeModel;

public interface EmployeeDao {
	public List<EmployeeModel> getList();
	public List<EmployeeModel> search(String key);
	public EmployeeModel getById(Integer id);
	public void insert(EmployeeModel model);
	public void update(EmployeeModel model);
	public void delete(EmployeeModel model);

}
