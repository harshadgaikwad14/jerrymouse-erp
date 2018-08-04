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

import com.erp.action.api.model.Status;
import com.erp.action.api.service.StatusService;



/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class StatusRestController {

	@Autowired
	StatusService statusService;

	@GetMapping("/status")
	public List<Status> findAllStatuss() {
		return statusService.findAllStatus();
	}

	@PostMapping("/status")
	public Status createStatus(@RequestBody Status status) {
		System.out.println("StatusController -- createStatus -- Status : "+status);
		return statusService.createStatus(status);
	}

	@GetMapping("/status/{id}")
	public Status getStatusById(@PathVariable(value = "id") Long statusId) {
		return statusService.getStatusById(statusId);
	}

	@PutMapping("/status/{id}")
	public Status updateStatus(@PathVariable(value = "id") Long statusId,
			@Valid @RequestBody Status status) {

		return statusService.updateStatus(statusId, status);
	}

	@DeleteMapping("/status/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long statusId) {
		statusService.deleteStatus(statusId);

		return ResponseEntity.ok().build();
	}
}
