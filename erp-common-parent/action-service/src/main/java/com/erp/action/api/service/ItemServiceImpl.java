package com.erp.action.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.Item;
import com.erp.action.api.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> findAllItems() {
		return (List<Item>) itemRepository.findAll();
	}

	@Override
	public Item getItemById(long itemId) {
		return itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));
	}

	@Override
	public Item updateItem(long itemId, Item item) {
		Item i = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));

		i.setItemDesc(item.getItemDesc());
		i.setItemName(item.getItemName());
		Item updatedItem = itemRepository.save(i);

		return updatedItem;
	}

	@Override
	public void deleteItem(long itemId) {
		Item i = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));

		itemRepository.delete(i);

	}

	@Override
	public void enableDisableItem(long ItemId, boolean isActive) {
		// TODO Auto-generated method stub

	}

	
}
