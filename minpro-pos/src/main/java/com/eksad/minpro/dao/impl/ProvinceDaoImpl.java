package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.ProvinceDao;
import com.eksad.minpro.model.ProvinceModel;

@Repository
public class ProvinceDaoImpl implements ProvinceDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProvinceModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from ProvinceModel ca";
		Query query = session.createQuery(hql);
		List<ProvinceModel> result = query.getResultList();
		return result;
	}

}
