package com.eksad.minpro.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.minpro.dao.DistrictDao;
import com.eksad.minpro.model.DistrictModel;

@Repository
public class DistrictDaoImpl implements DistrictDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<DistrictModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select sm from DistrictModel sm";
		Query query = session.createQuery(hql);
		List<DistrictModel> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DistrictModel> getByIdDistrict(Long id) {
		Session session = sessionFactory.getCurrentSession();
		// HQl artinya Hibernate Query language
		// Hibernate artinya ORM ( Object Relation Mapping )
		String hql = "select ca from DistrictModel ca where ca.regionId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<DistrictModel> result = query.getResultList();
		return result;
	}

}
