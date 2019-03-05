package com.eksad.minpro.service;

import java.util.List;

import com.eksad.minpro.model.PoModel;


public interface PoService {
	public List<PoModel> getList();
	public List<PoModel> search(String tglAwal, String tglAkhir, String status, String poNo);
	public PoModel getById(Long id);
	public void insert(PoModel model);
	public void update(PoModel model);
	public void delete(PoModel model);
}
