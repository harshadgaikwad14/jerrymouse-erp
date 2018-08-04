package com.erp.action.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.User;
import com.erp.action.api.repository.UserRepository;
import com.erp.action.api.service.transformer.TransformToListUserWrapper;
import com.erp.action.api.service.transformer.TransformToUser;
import com.erp.action.api.service.transformer.TransformToUserWrapper;
import com.erp.common.wrapper.model.ClientWrapper;
import com.erp.common.wrapper.model.RoleWrapper;
import com.erp.common.wrapper.model.UserWrapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientService clientService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private TransformToUser transformToUser;

	@Autowired
	private TransformToUserWrapper transformToUserWrapper;

	@Autowired
	private TransformToListUserWrapper transformToListUserWrapper;

	@Override
	public List<UserWrapper> findAllUsers() {

		List<UserWrapper> list = new ArrayList<>();
		list = transformToListUserWrapper.transform((List<User>) userRepository.findAll(), list);
		return list;
	}

	@Override
	public void deleteUser(final long userId) {
		User g = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		userRepository.delete(g);

	}

	@Override
	public UserWrapper createUser(final UserWrapper userWrapper) {

		ClientWrapper clientWrapper = clientService.getClientByClientNameAndActive(
				userWrapper.getClient().getClientName(), userWrapper.getClient().isActive());

		userWrapper.setClient(clientWrapper);

		Set<RoleWrapper> roleWrappers = roleService.findAllRoles();

		userWrapper.setRoles(roleWrappers);

		User user = transformToUser.transform(userWrapper, new User());

		transformToUserWrapper.transform(userRepository.save(user), userWrapper);

		return userWrapper;

	}

	@Override
	public UserWrapper getUserById(final long userId) {

		UserWrapper userWrapper = new UserWrapper();

		Optional<User> user = userRepository.findById(userId);
		userWrapper = transformToUserWrapper.transform(user.get(), userWrapper);
		return userWrapper;
	}

	@Override
	public void updateUser(final long userId, UserWrapper userWrapper) {

		Optional<User> optional = userRepository.findById(userId);

		if (optional.isPresent() && optional.get().getId() == userWrapper.getId()) {
			User add = transformToUser.transform(userWrapper, new User());

			userRepository.save(add);

		}
	}

}
