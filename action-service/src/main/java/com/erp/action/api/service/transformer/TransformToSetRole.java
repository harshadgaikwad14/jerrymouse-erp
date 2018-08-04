package com.erp.action.api.service.transformer;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Role;
import com.erp.common.wrapper.model.RoleWrapper;

@Component
public class TransformToSetRole implements Transformer<Set<RoleWrapper>, Set<Role>> {

	@Override
	public Set<Role> transform(Set<RoleWrapper> input, Set<Role> output) {

		for (RoleWrapper roleWrapper : input) {
			Role role = new Role();
			role.setId(roleWrapper.getId());
			role.setActive(roleWrapper.isActive());
			role.setRoleName(roleWrapper.getRoleName());
			role.setCreatedDate(roleWrapper.getCreatedDate());
			role.setUpdatedDate(roleWrapper.getUpdatedDate());
			output.add(role);
		}

		return output;
	}

}
