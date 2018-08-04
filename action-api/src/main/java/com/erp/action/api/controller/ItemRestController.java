package com.erp.action.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.action.api.model.Item;
import com.erp.action.api.service.ItemService;

/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class ItemRestController {

	@Autowired
	ItemService itemService;

	@GetMapping("/items")
	public List<Item> findAllItems() {
		return itemService.findAllItems();
	}

	@PostMapping("/items")
	public Item createItem(@RequestBody Item item) {

		return itemService.createItem(item);
	}

	@GetMapping("/items/{id}")
	public Item getItemById(@PathVariable(value = "id") Long itemId) {
		return itemService.getItemById(itemId);
	}

	@PutMapping("/items/{id}")
	public Item updateItem(@PathVariable(value = "id") Long itemId, @Valid @RequestBody Item item) {

		return itemService.updateItem(itemId, item);
	}

	@DeleteMapping("/items/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "id") Long itemId) {
		itemService.deleteItem(itemId);

		return ResponseEntity.ok().build();
	}
}
