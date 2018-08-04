package com.erp.action.api.service.transformer;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Address;
import com.erp.common.wrapper.model.AddressWrapper;
@Component
public  class TransformToAddressWrapper implements Transformer<Address,AddressWrapper> {

	@Override
	public AddressWrapper transform(final Address address, final AddressWrapper addressWrapper) {
		addressWrapper.setId(address.getId());
		addressWrapper.setAddressLine1(address.getAddressLine1());
		addressWrapper.setAddressLine2(address.getAddressLine2());
		addressWrapper.setAddressLine3(address.getAddressLine3());
		addressWrapper.setCity(address.getCity());
		addressWrapper.setCountry(address.getCountry());
		addressWrapper.setState(address.getState());
		addressWrapper.setZipCode(address.getZipCode());
		addressWrapper.setCreatedDate(address.getCreatedDate());
		addressWrapper.setUpdatedDate(address.getUpdatedDate());
		return addressWrapper;
	}

	



	

	

}
