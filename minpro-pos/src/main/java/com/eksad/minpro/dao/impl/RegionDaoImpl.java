package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.RegionDao;
import com.eksad.minpro.model.RegionModel;

@Repository
public class RegionDaoImpl implements RegionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RegionModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from RegionModel ca";
		Query query = session.createQuery(hql);
		List<RegionModel> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RegionModel> getByIdRegion(Long id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from RegionModel ca where ca.provinceId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<RegionModel> result = query.getResultList();
		return result;
	}
}
