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

import com.erp.action.api.service.UserService;
import com.erp.common.wrapper.model.UserWrapper;

/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<UserWrapper> findAllUsers() {
		return userService.findAllUsers();
	}

	@PostMapping("/users")
	public UserWrapper createUser(@RequestBody final UserWrapper userWrapper) {

		return userService.createUser(userWrapper);
	}

	@GetMapping("/users/{id}")
	public UserWrapper getUserById(@PathVariable(value = "id") final long userId) {
		return userService.getUserById(userId);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "id") final long userId,
			@Valid @RequestBody final UserWrapper userWrapper) {

		userService.updateUser(userId, userWrapper);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") final long userId) {
		userService.deleteUser(userId);

		return ResponseEntity.ok().build();
	}
}
