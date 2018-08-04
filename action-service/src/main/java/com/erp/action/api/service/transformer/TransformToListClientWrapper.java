package com.erp.action.api.service.transformer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.erp.action.api.model.Client;
import com.erp.common.wrapper.model.ClientWrapper;

@Component
public class TransformToListClientWrapper implements Transformer<List<Client>, List<ClientWrapper>> {

	@Override
	public List<ClientWrapper> transform(List<Client> input, List<ClientWrapper> output) {

		for (Client client : input) {
			ClientWrapper clientWrapper = new ClientWrapper();
			clientWrapper.setId(client.getId());
			clientWrapper.setActive(client.isActive());
			clientWrapper.setClientName(client.getClientName());
			clientWrapper.setCreatedDate(client.getCreatedDate());
			clientWrapper.setUpdatedDate(client.getUpdatedDate());
			output.add(clientWrapper);
		}

		return output;
	}

}
