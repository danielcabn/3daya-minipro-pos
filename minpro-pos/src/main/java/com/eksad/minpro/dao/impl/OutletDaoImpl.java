package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.OutletDao;
import com.eksad.minpro.model.OutletModel;

@Repository
public class OutletDaoImpl implements OutletDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OutletModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from OutletModel ca";
		Query query = session.createQuery(hql);
		List<OutletModel> result = query.getResultList();
		return result;
	}

	@Override
	public OutletModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from OutletModel ca where ca.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		OutletModel result = (OutletModel) query.getSingleResult();
		return result;
	}
	
	@Override
	public void insert(OutletModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}
	
	@Override
	public void update(OutletModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}
	
	@Override
	public List<OutletModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from OutletModel x where x.name like :keySearch";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");
		return query.getResultList();
	}

}