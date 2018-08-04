package com.erp.action.api.service;

import java.util.List;

import com.erp.action.api.model.Vendor;



public interface VendorService {
	
	public Vendor createVendor( Vendor vendor);
	public List<Vendor> findAllVendors();
	public Vendor getVendorById(final long vendorId);
	public Vendor updateVendor(final long vendorId,final Vendor vendor);
	public void deleteVendor(final long vendorId);
	public void enableDisableVendor(final long vendorId,final boolean isActive );
	

}
