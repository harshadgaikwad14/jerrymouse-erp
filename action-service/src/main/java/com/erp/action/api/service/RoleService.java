package com.erp.action.api.service;

import java.util.Set;

import com.erp.common.wrapper.model.RoleWrapper;



public interface RoleService {
	
	public RoleWrapper createRole(final RoleWrapper role);
	public Set<RoleWrapper> findAllRoles();
	public RoleWrapper getRoleById(final long roleId);
	public void updateRole(final long roleId,final RoleWrapper role);
	public void deleteRole(final long roleId);
	

}
