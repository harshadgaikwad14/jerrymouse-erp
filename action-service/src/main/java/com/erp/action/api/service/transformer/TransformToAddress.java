package com.erp.action.api.service.transformer;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Address;
import com.erp.common.wrapper.model.AddressWrapper;

@Component
public class TransformToAddress implements Transformer<AddressWrapper, Address> {

	@Override
	public Address transform(final AddressWrapper addressWrapper, final Address address) {

		address.setId(addressWrapper.getId());
		address.setAddressLine1(addressWrapper.getAddressLine1());
		address.setAddressLine2(addressWrapper.getAddressLine2());
		address.setAddressLine3(addressWrapper.getAddressLine3());
		address.setCity(addressWrapper.getCity());
		address.setCountry(addressWrapper.getCountry());
		address.setState(addressWrapper.getState());
		address.setZipCode(addressWrapper.getZipCode());
		address.setCreatedDate(addressWrapper.getCreatedDate());
		address.setUpdatedDate(addressWrapper.getUpdatedDate());

		return address;
	}

}
