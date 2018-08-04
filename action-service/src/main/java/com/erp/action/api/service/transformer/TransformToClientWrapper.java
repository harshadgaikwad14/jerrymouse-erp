package com.erp.action.api.service.transformer;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Client;
import com.erp.common.wrapper.model.ClientWrapper;
@Component
public  class TransformToClientWrapper implements Transformer<Client,ClientWrapper> {

	@Override
	public ClientWrapper transform(final Client client, final ClientWrapper clientWrapper) {
	
		clientWrapper.setId(client.getId());
		clientWrapper.setActive(client.isActive());
		clientWrapper.setClientName(client.getClientName());
		clientWrapper.setCreatedDate(client.getCreatedDate());
		clientWrapper.setUpdatedDate(client.getUpdatedDate());
		return clientWrapper;
	}

	



	

	

}
