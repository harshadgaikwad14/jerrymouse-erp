package com.erp.action.api.service;

import java.util.List;

import com.erp.common.wrapper.model.ClientWrapper;



public interface ClientService {
	
	public ClientWrapper createClient(final ClientWrapper clientWrapper);
	public List<ClientWrapper> findAllClients();
	public ClientWrapper getClientById(final long clientWrapperId);
	public ClientWrapper getClientByClientNameAndActive(final String clientWrapperName,final boolean active);
	public void updateClient(final long clientWrapperId,final ClientWrapper clientWrapper);
	public void deleteClient(final long clientWrapperId);
	

}
