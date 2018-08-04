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

import com.erp.action.api.service.AddressService;
import com.erp.common.wrapper.model.AddressWrapper;

/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class AddressRestController {

	@Autowired
	AddressService addressService;

	@GetMapping("/address")
	public List<AddressWrapper> findAllAddresss() {
		return addressService.findAllAddresss();
	}

	@PostMapping("/address")
	public AddressWrapper createAddress(@RequestBody final AddressWrapper addressWrapper) {

		return addressService.createAddress(addressWrapper);
	}

	@GetMapping("/address/{id}")
	public AddressWrapper getAddressById(@PathVariable(value = "id") final long addressId) {
		return addressService.getAddressById(addressId);
	}

	@PutMapping("/address/{id}")
	public ResponseEntity<?> updateAddress(@PathVariable(value = "id") final long addressId, @Valid @RequestBody final AddressWrapper addressWrapper) {

		 addressService.updateAddress(addressId, addressWrapper);
		 
		 return ResponseEntity.ok().build();
	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") final long addressId) {
		addressService.deleteAddress(addressId);

		return ResponseEntity.ok().build();
	}
}
