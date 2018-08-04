package com.erp.action.api.service.transformer;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.erp.action.api.model.Address;
import com.erp.action.api.model.Client;
import com.erp.action.api.model.Role;
import com.erp.action.api.model.User;
import com.erp.common.wrapper.model.AddressWrapper;
import com.erp.common.wrapper.model.ClientWrapper;
import com.erp.common.wrapper.model.RoleWrapper;
import com.erp.common.wrapper.model.UserWrapper;
@Component
public  class TransformToUserWrapper implements Transformer<User,UserWrapper> {
	
	@Autowired
	TransformToAddressWrapper transformToAddressWrapper;
	
	@Autowired
	TransformToClientWrapper transformToClientWrapper;
	
	@Autowired
	private TransformToSetRoleWrapper transformToSetRoleWrapper;


	@Override
	public UserWrapper transform(final User user, final UserWrapper userWrapper) {
	
		userWrapper.setId(user.getId());
		userWrapper.setActive(user.isActive());
		userWrapper.setUserName(user.getUserName());

		Address address = user.getAddress();
		AddressWrapper addressWrapper = new AddressWrapper();
		userWrapper.setAddress(transformToAddressWrapper.transform(address, addressWrapper));

		ClientWrapper clientWrapper = new ClientWrapper();
		Client client = user.getClient();
		userWrapper.setClient(transformToClientWrapper.transform(client, clientWrapper));

		Set<RoleWrapper> roleWrappers = new HashSet<>();
		Set<Role> roles = user.getRoles();
		userWrapper.setRoles(transformToSetRoleWrapper.transform(roles, roleWrappers));

		userWrapper.setLastName(user.getLastName());
		userWrapper.setFirstName(user.getFirstName());
		userWrapper.setEmailId(user.getEmailId());
		userWrapper.setMiddleName(user.getMiddleName());
		userWrapper.setMobileNumber(user.getMobileNumber());
		userWrapper.setPhoneNumber(user.getPhoneNumber());
		userWrapper.setUserPassword(userWrapper.getUserPassword());

		userWrapper.setCreatedDate(user.getCreatedDate());
		userWrapper.setUpdatedDate(user.getUpdatedDate());
		return userWrapper;
	}

	



	

	

}
