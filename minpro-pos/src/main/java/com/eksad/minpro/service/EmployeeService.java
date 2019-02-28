package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.EmployeeForm;
import com.eksad.minpro.model.EmployeeModel;


public interface EmployeeService {
	public List<EmployeeModel> getList();
	public EmployeeModel getById(Integer id);
	public void insert(EmployeeForm model);
	public void update(EmployeeModel model);

	
}
