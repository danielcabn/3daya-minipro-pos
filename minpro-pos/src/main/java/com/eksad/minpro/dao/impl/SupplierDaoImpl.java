package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.SupplierDao;
import com.eksad.minpro.model.SupplierModel;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SupplierModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from SupplierModel ca";
		Query query = session.createQuery(hql);
		List<SupplierModel> result = query.getResultList();
		return result;
	}

	@Override
	public SupplierModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from SupplierModel ca where ca.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		SupplierModel result = (SupplierModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(SupplierModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public List<SupplierModel> search(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}