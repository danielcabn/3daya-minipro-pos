package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.PoDao;

import com.eksad.minpro.model.PoModel;

@Repository
public class PoDaoImpl implements PoDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<PoModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select pom from PoModel pom";
		Query query = session.createQuery(hql);
		List<PoModel> result = query.getResultList();
		return result;
	}

	@Override
	public PoModel getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select pom from PoModel pom where pom.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		PoModel result = (PoModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(PoModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public void update(PoModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(PoModel model) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PoModel> search(String tglAwal, String tglAkhir, String status, String poNo) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select pom from PoModel pom where (pom.createdOn between '"+tglAwal+"' and '"+tglAkhir+"')"+
					  "and (pom.status='"+status+"') and (pom.poNo='"+poNo+"')";
		Query query = session.createQuery(hql);
		List<PoModel> result = query.getResultList();
		return result;
	}

}