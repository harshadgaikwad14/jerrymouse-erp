package com.erp.action.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.VendorType;
import com.erp.action.api.repository.VendorTypeRepository;

@Service
public class VendorTypeServiceImpl implements VendorTypeService {

	@Autowired
	VendorTypeRepository vendorTypeRepository;

	@Override
	public VendorType createVendorType( VendorType vendorType) {

		System.out.println("VendorTypeServiceImpl -- createVendorType -- vendorType : "+vendorType);
		return vendorTypeRepository.save(vendorType);
	}

	@Override
	public List<VendorType> findAllVendorTypes() {

		return (List<VendorType>) vendorTypeRepository.findAll();
	}

	@Override
	public VendorType getVendorTypeById(final long vendorTypeId) {
		return vendorTypeRepository.findById(vendorTypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendor Type", "id", vendorTypeId));
	}

	@Override
	public VendorType updateVendorType(long vendorTypeId, VendorType vendorType) {

		VendorType vt = vendorTypeRepository.findById(vendorTypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendor Type", "id", vendorTypeId));

		vt.setTypeName(vendorType.getTypeName());
		vt.setTypeDesc(vendorType.getTypeDesc());
		vt.setActive(vendorType.isActive());

		VendorType updatedVendorType = vendorTypeRepository.save(vt);

		return updatedVendorType;
	}

	@Override
	public void deleteVendorType(final long vendorTypeId) {

		VendorType vendorType = vendorTypeRepository.findById(vendorTypeId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendor Type", "id", vendorTypeId));

		vendorTypeRepository.delete(vendorType);
		
		
	}

	@Override
	public void enableDisableVendorType(long vendorTypeId, boolean flag) {
		
	}

}
