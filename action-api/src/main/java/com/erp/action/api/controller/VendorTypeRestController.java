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

import com.erp.action.api.model.VendorType;
import com.erp.action.api.service.VendorTypeService;



/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class VendorTypeRestController {

	@Autowired
	VendorTypeService vendorTypeService;

	@GetMapping("/vendorTypes")
	public List<VendorType> findAllVendorTypes() {
		return vendorTypeService.findAllVendorTypes();
	}

	@PostMapping("/vendorTypes")
	public VendorType createVendorType(@RequestBody VendorType vendorType) {
		System.out.println("VendorTypeController -- createVendorType -- vendorType : "+vendorType);
		return vendorTypeService.createVendorType(vendorType);
	}

	@GetMapping("/vendorTypes/{id}")
	public VendorType getVendorTypeById(@PathVariable(value = "id") Long vendorTypeId) {
		return vendorTypeService.getVendorTypeById(vendorTypeId);
	}

	@PutMapping("/vendorTypes/{id}")
	public VendorType updateVendorType(@PathVariable(value = "id") Long vendorTypeId,
			@Valid @RequestBody VendorType vendorType) {

		return vendorTypeService.updateVendorType(vendorTypeId, vendorType);
	}

	@DeleteMapping("/vendorTypes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long vendorTypeId) {
		vendorTypeService.deleteVendorType(vendorTypeId);

		return ResponseEntity.ok().build();
	}
}
