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
public class TransformToUser implements Transformer<UserWrapper, User> {

	@Autowired
	private TransformToAddress transformToAddress;

	@Autowired
	private TransformToClient transformToClient;

	@Autowired
	private TransformToSetRole transformToListRole;

	@Override
	public User transform(final UserWrapper userWrapper, final User user) {

		user.setId(userWrapper.getId());
		user.setActive(userWrapper.isActive());
		user.setUserName(userWrapper.getUserName());

		AddressWrapper addressWrapper = userWrapper.getAddress();
		Address address = new Address();
		user.setAddress(transformToAddress.transform(addressWrapper, address));

		ClientWrapper clientWrapper = userWrapper.getClient();
		Client client = new Client();
		user.setClient(transformToClient.transform(clientWrapper, client));

		Set<RoleWrapper> roleWrappers = userWrapper.getRoles();
		Set<Role> roles = new HashSet<>();
		user.setRoles(transformToListRole.transform(roleWrappers, roles));

		user.setLastName(userWrapper.getLastName());
		user.setFirstName(userWrapper.getFirstName());
		user.setEmailId(userWrapper.getEmailId());
		user.setMiddleName(userWrapper.getMiddleName());
		user.setMobileNumber(userWrapper.getMobileNumber());
		user.setPhoneNumber(userWrapper.getPhoneNumber());
		user.setUserPassword(userWrapper.getUserPassword());

		user.setCreatedDate(userWrapper.getCreatedDate());
		user.setUpdatedDate(userWrapper.getUpdatedDate());

		return user;
	}

}
