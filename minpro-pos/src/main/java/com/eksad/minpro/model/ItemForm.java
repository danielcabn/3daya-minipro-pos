package com.eksad.minpro.model;

import java.util.List;

public class ItemForm {
private ItemModel io;
private List<VariantModel> adv;
private List<InvenModel> in;

public ItemModel getIo() {
	return io;
}
public void setIo(ItemModel io) {
	this.io = io;
}
public List<VariantModel> getAdv() {
	return adv;
}
public void setAdv(List<VariantModel> adv) {
	this.adv = adv;
}
public List<InvenModel> getIn() {
	return in;
}
public void setIn(List<InvenModel> in) {
	this.in = in;
}

}
	