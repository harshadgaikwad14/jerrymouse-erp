package com.erp.action.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.Address;
import com.erp.action.api.repository.AddressRepository;
import com.erp.action.api.service.transformer.TransformToAddress;
import com.erp.action.api.service.transformer.TransformToAddressWrapper;
import com.erp.action.api.service.transformer.TransformToListAddressWrapper;
import com.erp.common.wrapper.model.AddressWrapper;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	TransformToAddress transformToAddress;

	@Autowired
	TransformToAddressWrapper transformToAddressWrapper;

	@Autowired
	TransformToListAddressWrapper listAddressWrapperTransformer;

	@Override
	public AddressWrapper createAddress(final AddressWrapper addressWrapper) {

		Address address = transformToAddress.transform(addressWrapper, new Address());

		transformToAddressWrapper.transform(addressRepository.save(address), addressWrapper);

		return addressWrapper;
	}

	@Override
	public List<AddressWrapper> findAllAddresss() {
		List<AddressWrapper> list = new ArrayList<>();
		list = listAddressWrapperTransformer.transform((List<Address>) addressRepository.findAll(), list);
		return list;
	}

	@Override
	public AddressWrapper getAddressById(long addressId) {
		AddressWrapper addressWrapper = new AddressWrapper();

		Optional<Address> address = addressRepository.findById(addressId);
		addressWrapper = transformToAddressWrapper.transform(address.get(), addressWrapper);
		return addressWrapper;
	}

	@Override
	public void updateAddress(long addressId, AddressWrapper addressWrapper) {
		
		System.out.println("Before addressWrapper"+addressWrapper);

		Optional<Address> optional = addressRepository.findById(addressId);

		if(optional.isPresent() && optional.get().getId() == addressWrapper.getId())
		{
			Address add = transformToAddress.transform(addressWrapper, new Address());
			
			System.out.println("After addressWrapper"+addressWrapper);
			addressRepository.save(add);

		}
		
	

		
	}

	@Override
	public void deleteAddress(long addressId) {
		Address g = addressRepository.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "id", addressId));

		addressRepository.delete(g);

	}

}
