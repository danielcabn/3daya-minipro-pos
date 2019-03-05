package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.EmployeeOutletModel;


public interface EmployeeOutletDao {
	public List<EmployeeOutletModel> getList();
	public EmployeeOutletModel getById(Integer id);
	public void insert(EmployeeOutletModel model);

}
