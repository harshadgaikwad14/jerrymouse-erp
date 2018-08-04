package com.erp.common.wrapper.model;

import java.io.Serializable;
import java.util.Date;



public class RoleWrapper implements Serializable {

	@Override
	public String toString() {
		return "RoleWrapper [id=" + id + ", roleName=" + roleName + ", active=" + active + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String roleName;

	private boolean active;

	private Date createdDate;

	private Date updatedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
