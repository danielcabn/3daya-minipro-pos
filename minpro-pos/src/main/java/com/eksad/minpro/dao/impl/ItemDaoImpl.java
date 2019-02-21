package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.ItemDao;
import com.eksad.minpro.model.CategoryModel;
import com.eksad.minpro.model.ItemModel;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ItemModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select ct from ItemModel ct";
		Query query = session.createQuery(hql);
		List<ItemModel> result = query.getResultList();
		return result;
	}

	@Override
	public void insert(ItemModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}


	
}