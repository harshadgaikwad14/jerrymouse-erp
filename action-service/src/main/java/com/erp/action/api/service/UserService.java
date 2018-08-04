package com.erp.action.api.service;

import java.util.List;

import com.erp.common.wrapper.model.UserWrapper;



public interface UserService {
	
	public UserWrapper createUser( UserWrapper userWrapper);
	public List<UserWrapper> findAllUsers();
	public UserWrapper getUserById(final long userId);
	public void updateUser(final long userId,final UserWrapper userWrapper);
	public void deleteUser(final long userId);
	

}
