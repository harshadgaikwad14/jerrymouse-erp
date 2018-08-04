package com.erp.action.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.Role;
import com.erp.action.api.repository.RoleRepository;
import com.erp.action.api.service.transformer.TransformToRole;
import com.erp.action.api.service.transformer.TransformToRoleWrapper;
import com.erp.action.api.service.transformer.TransformToSetRoleWrapper;
import com.erp.common.wrapper.model.RoleWrapper;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private TransformToRole transformToRole;

	@Autowired
	private TransformToRoleWrapper transformToRoleWrapper;

	@Autowired
	TransformToSetRoleWrapper transformToSetRoleWrapper;

	@Override
	public void deleteRole(long roleId) {
		Role g = roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role", "id", roleId));

		roleRepository.delete(g);

	}

	@Override
	public RoleWrapper createRole(RoleWrapper roleWrapper) {

		Role role = transformToRole.transform(roleWrapper, new Role());

		transformToRoleWrapper.transform(roleRepository.save(role), roleWrapper);

		return roleWrapper;
	}

	@Override
	public RoleWrapper getRoleById(final long roleId) {
		RoleWrapper roleWrapper = new RoleWrapper();

		Optional<Role> role = roleRepository.findById(roleId);
		System.out.println(">>> role : "+role.get());
		roleWrapper = transformToRoleWrapper.transform(role.get(), roleWrapper);
		return roleWrapper;
	}

	@Override
	public void updateRole(final long roleId, final RoleWrapper roleWrapper) {

		Optional<Role> optional = roleRepository.findById(roleId);

		if (optional.isPresent() && optional.get().getId() == roleWrapper.getId()) {
			Role add = transformToRole.transform(roleWrapper, new Role());

			roleRepository.save(add);

		}

	}

	@Override
	public Set<RoleWrapper> findAllRoles() {
		Set<RoleWrapper> roleWrappers = new HashSet<>();
		List<Role> roles = (List<Role>) roleRepository.findAll();
		roleWrappers = transformToSetRoleWrapper.transform(new HashSet<>(roles), roleWrappers);
		return roleWrappers;
	}

}
