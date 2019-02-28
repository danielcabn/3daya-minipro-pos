package com.eksad.minpro.dao;

import java.util.List;

import com.eksad.minpro.model.PoModel;

public interface PoDao {
	public List<PoModel> getList();
	public PoModel getById(Long id);
	public List<PoModel> search(String tglAwal, String tglAkhir, String status, String poNo);
	public void insert(PoModel model);
	public void update(PoModel model);
	public void delete(PoModel model);

}