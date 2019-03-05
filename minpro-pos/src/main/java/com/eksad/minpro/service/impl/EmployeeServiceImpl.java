package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.EmployeeDao;
import com.eksad.minpro.dao.EmployeeOutletDao;
import com.eksad.minpro.dao.UserDao;
import com.eksad.minpro.model.EmployeeForm;
import com.eksad.minpro.model.EmployeeModel;
import com.eksad.minpro.model.EmployeeOutletModel;
import com.eksad.minpro.model.UserModel;
import com.eksad.minpro.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao emdao;
	@Autowired
	private EmployeeOutletDao eodao;
	@Autowired
	private UserDao udao;

	@Override
	public List<EmployeeModel> getList() {
		return this.emdao.getList();
	}

	@Override
	public EmployeeModel getById(Integer id) {
		return this.emdao.getById(id);
	}
	

	@Override
	public void insert(EmployeeForm model) {

		EmployeeModel em = model.getEm();
		this.emdao.insert(model.getEm());
		UserModel ur = model.getUr();
		ur.setEmployeeId(em.getId());
		this.udao.insert(ur);

		// input ke tabel pod
		if (model.getEo() != null) {
			for (EmployeeOutletModel eo : model.getEo()) {
				eo.setEmployeeId(em.getId());
				this.eodao.insert(eo);
			}

		}		

	}

	@Override
	public void update(EmployeeModel model) {
		this.emdao.update(model);
	}

}
