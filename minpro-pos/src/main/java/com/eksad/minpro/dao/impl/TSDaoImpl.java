package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.TSDao;
import com.eksad.minpro.model.RegionModel;
import com.eksad.minpro.model.TSModel;

@Repository
public class TSDaoImpl implements TSDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TSModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select ca from TSModel ca";
		Query query =  session.createQuery(hql);
		List<TSModel> result = query.getResultList();
		return result;
	}

	@Override
	public List<TSModel> getByIdTS(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from TSModel ca where ca.toOutlet=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TSModel> result = query.getResultList();
		return result;
	}

	@Override
	public void insert(TSModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}


	
}
