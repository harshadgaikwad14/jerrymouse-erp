package com.erp.action.api.service;

import java.util.List;

import com.erp.action.api.model.Status;



public interface StatusService {
	
	public Status createStatus( Status status);
	public List<Status> findAllStatus();
	public Status getStatusById(final long statusId);
	public Status updateStatus(final long statusId,final Status status);
	public void deleteStatus(final long statusId);


}
