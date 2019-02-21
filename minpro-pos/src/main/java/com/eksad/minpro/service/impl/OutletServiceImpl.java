package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.OutletDao;
import com.eksad.minpro.model.OutletModel;
import com.eksad.minpro.service.OutletService;

@Service
@Transactional
public class OutletServiceImpl implements OutletService {
	@Autowired
	private OutletDao dao;
	
	@Override
	public List<OutletModel> getList() {
		return this.dao.getList();
	}

	@Override
	public OutletModel getById(Integer id) {
		return this.dao.getById(id);
	}
	
	@Override
	public void insert(OutletModel model) {
		this.dao.insert(model);
	}
<<<<<<< HEAD:minpro-pos/src/main/java/com/eksad/minpro/service/impl/SupplierServiceImpl.java


	@Override
	public List<SupplierModel> search(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
=======
}
>>>>>>> Tika:minpro-pos/src/main/java/com/eksad/minpro/service/impl/OutletServiceImpl.java
