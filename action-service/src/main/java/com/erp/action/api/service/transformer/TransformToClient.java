package com.erp.action.api.service.transformer;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Client;
import com.erp.common.wrapper.model.ClientWrapper;

@Component
public class TransformToClient implements Transformer<ClientWrapper, Client> {

	@Override
	public Client transform(final ClientWrapper clientWrapper, final Client client) {
		
		client.setId(clientWrapper.getId());
		client.setActive(clientWrapper.isActive());
		client.setClientName(clientWrapper.getClientName());
		client.setCreatedDate(clientWrapper.getCreatedDate());
		client.setUpdatedDate(clientWrapper.getUpdatedDate());

		return client;
	}

}
