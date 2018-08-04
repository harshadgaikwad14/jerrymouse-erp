package com.erp.action.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.Vendor;
import com.erp.action.api.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor createVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@Override
	public List<Vendor> findAllVendors() {
		return (List<Vendor>) vendorRepository.findAll();
	}

	@Override
	public Vendor getVendorById(long vendorId) {
		return vendorRepository.findById(vendorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendor", "id", vendorId));
	}

	@Override
	public Vendor updateVendor(long vendorId, Vendor vendor) {
		Vendor v = vendorRepository.findById(vendorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendor", "id", vendorId));

		v = vendor;
		Vendor updatedVendor = vendorRepository.save(v);

		return updatedVendor;
	}

	@Override
	public void deleteVendor(long vendorId) {
		Vendor g = vendorRepository.findById(vendorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendor", "id", vendorId));

		vendorRepository.delete(g);

	}

	@Override
	public void enableDisableVendor(long vendorId, boolean isActive) {
		// TODO Auto-generated method stub

	}

	
}
