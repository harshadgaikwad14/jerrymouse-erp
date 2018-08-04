package com.erp.action.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.Status;
import com.erp.action.api.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public Status createStatus(Status status) {
		return statusRepository.save(status);
	}

	@Override
	public List<Status> findAllStatus() {
		return (List<Status>) statusRepository.findAll();
	}

	@Override
	public Status getStatusById(long statusId) {
		return statusRepository.findById(statusId)
				.orElseThrow(() -> new ResourceNotFoundException("Status", "id", statusId));
	}

	@Override
	public Status updateStatus(long statusId, Status status) {
		Status u = statusRepository.findById(statusId)
				.orElseThrow(() -> new ResourceNotFoundException("Status", "id", statusId));

		
		Status updatedStatus = statusRepository.save(u);

		return updatedStatus;
	}

	@Override
	public void deleteStatus(long statusId) {
		Status u = statusRepository.findById(statusId)
				.orElseThrow(() -> new ResourceNotFoundException("Status", "id", statusId));

		statusRepository.delete(u);

	}

	
	
	
}
