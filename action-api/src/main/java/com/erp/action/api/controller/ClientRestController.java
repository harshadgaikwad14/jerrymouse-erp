package com.erp.action.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.action.api.service.ClientService;
import com.erp.common.wrapper.model.ClientWrapper;

/**
 * Created by Harshad on 23/06/2018
 */
@RestController
@RequestMapping("/api")
public class ClientRestController {

	@Autowired
	ClientService clientService;

	@GetMapping("/clients")
	public List<ClientWrapper> findAllClients() {
		return clientService.findAllClients();
	}

	@PostMapping("/clients")
	public ClientWrapper createClient(@RequestBody ClientWrapper client) {
		System.out.println("ClientController -- createClient -- Client : " + client);
		return clientService.createClient(client);
	}

	@GetMapping("/clients/{id}")
	public ClientWrapper getClientById(@PathVariable(value = "id") Long clientId) {
		return clientService.getClientById(clientId);
	}

	@GetMapping("/clients/{name}/{active}")
	public ClientWrapper getClientById(@PathVariable(value = "name") String clientName,
			@PathVariable(value = "active") boolean active) {

		System.out.println("clientName " + clientName);
		System.out.println("active " + active);
		return clientService.getClientByClientNameAndActive(clientName, active);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<?> updateClient(@PathVariable(value = "id") final long clientId,
			@Valid @RequestBody final ClientWrapper client) {
		
		System.out.println("updateClient : client : "+client);
		System.out.println("updateClient : clientId : "+clientId);

		clientService.updateClient(clientId, client);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long clientId) {
		clientService.deleteClient(clientId);

		return ResponseEntity.ok().build();
	}
}
