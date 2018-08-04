package com.erp.action.api.service;

import java.util.List;

import com.erp.common.wrapper.model.AddressWrapper;



public interface AddressService {
	
	public AddressWrapper createAddress( AddressWrapper address);
	public List<AddressWrapper> findAllAddresss();
	public AddressWrapper getAddressById(final long addressId);
	public void updateAddress(final long addressId,final AddressWrapper address);
	public void deleteAddress(final long addressId);
	

}
