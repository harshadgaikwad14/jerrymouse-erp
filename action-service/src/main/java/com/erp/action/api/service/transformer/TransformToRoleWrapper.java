package com.erp.action.api.service.transformer;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Role;
import com.erp.common.wrapper.model.RoleWrapper;
@Component
public  class TransformToRoleWrapper implements Transformer<Role,RoleWrapper> {

	@Override
	public RoleWrapper transform(final Role role, final RoleWrapper roleWrapper) {
	
		roleWrapper.setId(role.getId());
		roleWrapper.setActive(role.isActive());
		roleWrapper.setRoleName(role.getRoleName());
		roleWrapper.setCreatedDate(role.getCreatedDate());
		roleWrapper.setUpdatedDate(role.getUpdatedDate());
		return roleWrapper;
	}

	



	

	

}
