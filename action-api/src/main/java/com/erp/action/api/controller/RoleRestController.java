package com.erp.action.api.controller;

import java.util.Set;

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

import com.erp.action.api.service.RoleService;
import com.erp.common.wrapper.model.RoleWrapper;



/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class RoleRestController {

	@Autowired
	RoleService roleService;

	@GetMapping("/roles")
	public Set<RoleWrapper> findAllRoles() {
		return roleService.findAllRoles();
	}

	@PostMapping("/roles")
	public RoleWrapper createRole(@RequestBody RoleWrapper roleWrapper) {
		
		return roleService.createRole(roleWrapper);
	}

	@GetMapping("/roles/{id}")
	public RoleWrapper getRoleById(@PathVariable(value = "id") long roleId) {
		return roleService.getRoleById(roleId);
	}

	@PutMapping("/roles/{id}")
	public ResponseEntity<?> updateRole(@PathVariable(value = "id") Long roleId,
			@Valid @RequestBody RoleWrapper role) {

		 roleService.updateRole(roleId, role);
		
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/roles/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") long roleId) {
		roleService.deleteRole(roleId);

		return ResponseEntity.ok().build();
	}
}
