package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.CategoryDao;
import com.eksad.minpro.model.CategoryModel;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CategoryModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from CategoryModel ca";
		Query query = session.createQuery(hql);
		List<CategoryModel> result = query.getResultList();
		return result;
	}

	@Override
	public CategoryModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from CategoryModel ca where ca.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		CategoryModel result = (CategoryModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void update(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(CategoryModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<CategoryModel> search(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}