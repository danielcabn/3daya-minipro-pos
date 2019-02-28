package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.UserDao;
import com.eksad.minpro.model.UserModel;


@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from UserModel ep";
		Query query = session.createQuery(hql);
		List<UserModel> result = query.getResultList();
		return result;
	}

	@Override
	public UserModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ep from UserModel ep where ep.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		UserModel result = (UserModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(UserModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}
	

}