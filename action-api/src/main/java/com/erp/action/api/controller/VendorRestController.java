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

import com.erp.action.api.model.Vendor;
import com.erp.action.api.service.VendorService;

/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class VendorRestController {

	@Autowired
	VendorService vendorService;

	@GetMapping("/vendors")
	public List<Vendor> findAllVendors() {
		return vendorService.findAllVendors();
	}

	@PostMapping("/vendors")
	public Vendor createVendor(@RequestBody Vendor vendor) {

		return vendorService.createVendor(vendor);
	}

	@GetMapping("/vendors/{id}")
	public Vendor getVendorById(@PathVariable(value = "id") Long vendorId) {
		return vendorService.getVendorById(vendorId);
	}

	@PutMapping("/vendors/{id}")
	public Vendor updateVendor(@PathVariable(value = "id") Long vendorId, @Valid @RequestBody Vendor vendor) {

		return vendorService.updateVendor(vendorId, vendor);
	}

	@DeleteMapping("/vendors/{id}")
	public ResponseEntity<?> deleteVendor(@PathVariable(value = "id") Long vendorId) {
		vendorService.deleteVendor(vendorId);

		return ResponseEntity.ok().build();
	}
}
