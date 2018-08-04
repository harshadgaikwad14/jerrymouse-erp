package com.erp.action.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.action.api.exception.ResourceNotFoundException;
import com.erp.action.api.model.Client;
import com.erp.action.api.repository.ClientRepository;
import com.erp.action.api.service.transformer.TransformToClient;
import com.erp.action.api.service.transformer.TransformToClientWrapper;
import com.erp.action.api.service.transformer.TransformToListClientWrapper;
import com.erp.common.wrapper.model.ClientWrapper;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	TransformToClient transformToClient;

	@Autowired
	TransformToClientWrapper transformToClientWrapper;

	@Autowired
	TransformToListClientWrapper transformToListClientWrapper;

	@Override
	public ClientWrapper createClient(ClientWrapper clientWrapper) {

		Client client = transformToClient.transform(clientWrapper, new Client());

		transformToClientWrapper.transform(clientRepository.save(client), clientWrapper);

		return clientWrapper;

	}

	@Override
	public List<ClientWrapper> findAllClients() {

		List<ClientWrapper> list = new ArrayList<>();
		list = transformToListClientWrapper.transform((List<Client>) clientRepository.findAll(), list);
		return list;
	}

	@Override
	public ClientWrapper getClientById(long clientWrapperId) {
		ClientWrapper clientWrapper = new ClientWrapper();

		Optional<Client> client = clientRepository.findById(clientWrapperId);
		clientWrapper = transformToClientWrapper.transform(client.get(), clientWrapper);
		return clientWrapper;
	}

	@Override
	public ClientWrapper getClientByClientNameAndActive(String clientWrapperName, boolean active) {
		Client c = clientRepository.findByClientNameAndActive(clientWrapperName, active);

		ClientWrapper clientWrapper = new ClientWrapper();
		clientWrapper = transformToClientWrapper.transform(c, clientWrapper);
		return clientWrapper;
	}

	@Override
	public void updateClient(long clientWrapperId, ClientWrapper clientWrapper) {

		Optional<Client> optional = clientRepository.findById(clientWrapperId);
		
		System.out.println("optional.get() : "+optional.get());
		System.out.println("optional.isPresent() : "+optional.isPresent());
		System.out.println("clientWrapperId : "+clientWrapperId);
		System.out.println("clientWrapper : "+clientWrapper);

		if (optional.isPresent() && optional.get().getId() == clientWrapperId) {
			Client client = transformToClient.transform(clientWrapper, optional.get());
			System.out.println(">>>>> client : "+client);
			clientRepository.save(client);

		}

	}

	@Override
	public void deleteClient(long clientWrapperId) {

		Client g = clientRepository.findById(clientWrapperId)
				.orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientWrapperId));

		clientRepository.delete(g);
	}

}
