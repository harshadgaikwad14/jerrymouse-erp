package com.erp.action.api.service.transformer;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Role;
import com.erp.common.wrapper.model.RoleWrapper;

@Component
public class TransformToSetRoleWrapper implements Transformer<Set<Role>, Set<RoleWrapper>> {

	@Override
	public Set<RoleWrapper> transform(Set<Role> input, Set<RoleWrapper> output) {

		for (Role role : input) {
			RoleWrapper roleWrapper = new RoleWrapper();
			roleWrapper.setId(role.getId());
			roleWrapper.setActive(role.isActive());
			roleWrapper.setRoleName(role.getRoleName());
			roleWrapper.setCreatedDate(role.getCreatedDate());
			roleWrapper.setUpdatedDate(role.getUpdatedDate());
			output.add(roleWrapper);
		}

		return output;
	}

}
