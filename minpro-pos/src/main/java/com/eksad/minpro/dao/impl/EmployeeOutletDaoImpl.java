package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.EmployeeOutletDao;
import com.eksad.minpro.dao.UserDao;
import com.eksad.minpro.model.EmployeeOutletModel;


@Repository
public class EmployeeOutletDaoImpl implements EmployeeOutletDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmployeeOutletModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from EmployeeOutletModel ep";
		Query query = session.createQuery(hql);
		List<EmployeeOutletModel> result = query.getResultList();
		return result;
	}

	@Override
	public EmployeeOutletModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from EmployeeOutletModel ep where ep.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		EmployeeOutletModel result = (EmployeeOutletModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(EmployeeOutletModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}
	
	



}