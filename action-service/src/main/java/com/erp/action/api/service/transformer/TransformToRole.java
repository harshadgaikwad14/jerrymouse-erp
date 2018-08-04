package com.erp.action.api.service.transformer;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Role;
import com.erp.common.wrapper.model.RoleWrapper;

@Component
public class TransformToRole implements Transformer<RoleWrapper, Role> {

	@Override
	public Role transform(final RoleWrapper roleWrapper, final Role role) {

		role.setId(roleWrapper.getId());
		role.setActive(roleWrapper.isActive());
		role.setRoleName(roleWrapper.getRoleName());
		role.setCreatedDate(roleWrapper.getCreatedDate());
		role.setUpdatedDate(roleWrapper.getUpdatedDate());

		return role;
	}

}
