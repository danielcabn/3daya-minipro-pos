package com.eksad.minpro.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eksad.minpro.dao.InvenDao;
import com.eksad.minpro.model.InvenModel;

@Repository
public class InvenDaoImpl implements InvenDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(InvenModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
		
	}

	@Override
	public List<InvenModel> getList() {
		return null;
	}


	
	
}
