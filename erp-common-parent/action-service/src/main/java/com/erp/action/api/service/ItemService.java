package com.erp.action.api.service;

import java.util.List;

import com.erp.action.api.model.Item;



public interface ItemService {
	
	public Item createItem( Item item);
	public List<Item> findAllItems();
	public Item getItemById(final long itemId);
	public Item updateItem(final long itemId,final Item item);
	public void deleteItem(final long item);
	public void enableDisableItem(final long itemId,final boolean isActive );

}
