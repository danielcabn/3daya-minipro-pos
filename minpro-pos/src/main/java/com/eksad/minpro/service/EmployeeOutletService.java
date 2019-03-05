package com.eksad.minpro.service;

import java.util.List;


import com.eksad.minpro.model.EmployeeOutletModel;


public interface EmployeeOutletService {
	public List<EmployeeOutletModel> getList();
	public EmployeeOutletModel getById(Integer id);
	public void insert(EmployeeOutletModel item);

	
}
