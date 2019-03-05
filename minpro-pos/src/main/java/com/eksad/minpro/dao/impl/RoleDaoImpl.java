package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.RoleDao;
import com.eksad.minpro.model.RoleModel;


@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RoleModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from RoleModel ep";
		Query query = session.createQuery(hql);
		List<RoleModel> result = query.getResultList();
		return result;
	}

	@Override
	public RoleModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from RoleModel ep where ep.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		RoleModel result = (RoleModel) query.getSingleResult();
		return result;
	}

	
}