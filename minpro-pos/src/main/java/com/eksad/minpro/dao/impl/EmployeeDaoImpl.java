package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.EmployeeDao;
import com.eksad.minpro.model.EmployeeModel;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmployeeModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from EmployeeModel ep";
		Query query = session.createQuery(hql);
		List<EmployeeModel> result = query.getResultList();
		return result;
	}

	@Override
	public EmployeeModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from EmployeeModel ep where ep.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		EmployeeModel result = (EmployeeModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(EmployeeModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void update(EmployeeModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(EmployeeModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}
}