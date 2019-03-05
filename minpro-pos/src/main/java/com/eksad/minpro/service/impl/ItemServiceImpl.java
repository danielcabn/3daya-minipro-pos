package com.eksad.minpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.minpro.dao.InvenDao;
import com.eksad.minpro.dao.ItemDao;
import com.eksad.minpro.dao.VariantDao;
import com.eksad.minpro.model.InvenModel;
import com.eksad.minpro.model.ItemForm;
import com.eksad.minpro.model.ItemModel;
import com.eksad.minpro.model.SupplierModel;
import com.eksad.minpro.model.VariantModel;
import com.eksad.minpro.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao dao;

	@Autowired
	private VariantDao daoad;

	@Autowired
	private InvenDao daoin;

	@Override
	public List<ItemModel> getList() {
		return this.dao.getList();
	}
	
	@Override
	public List<InvenModel> getListInven() {
		return this.dao.getListInven();
	}
	
	@Override
	public void insert(ItemForm model) {
		ItemModel io = model.getIo();
		io.setActive(true);
		this.dao.insert(io);
		
		Integer idItem = io.getId();

		if (model.getAdv() != null) {
			for (VariantModel detail : model.getAdv()) {
				detail.setItemId(idItem);
				detail.setActive(true);
				detail.setModifiedBy(1);
				this.daoad.insert(detail);
				
				Integer idVariant = detail.getId();
				
				if (model.getIn() != null) {
					for (InvenModel inven : model.getIn()) {
						inven.setId(io.getId());
						inven.setVariantId(idVariant);
						inven.setOutletId(1);
						inven.setPurchaseQty(1);
						inven.setSalesOrderQty(1);
						inven.setTransferStockQty(1);
						inven.setAdjustmentQty(1);
						inven.setEndingQty(1);
						this.daoin.insert(inven);
					}
				}
			}
		}
	}

	@Override
	public List<ItemModel> search(String key) {
		return this.dao.search(key);
	}
	
	@Override
	public void update(ItemModel item) {
		this.dao.update(item);
		
	}

	@Override
	public ItemModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void delete(ItemModel item) {
		// TODO Auto-generated method stub
		
	}
}
