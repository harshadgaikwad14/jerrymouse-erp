package com.jerrymouse.action.api.service;

import java.util.List;

import com.jerrymouse.action.api.model.VendorType;

public interface VendorTypeService {
	
	public VendorType createVendorType( VendorType vendorType);
	public List<VendorType> findAllVendorTypes();
	public VendorType getVendorTypeById(final long vendorTypeId);
	public VendorType updateVendorType(final long vendorTypeId,final VendorType vendorType);
	public void deleteVendorType(final long vendorTypeId);
	public void enableDisableVendorType(final long vendorTypeId,final boolean flag );

}
