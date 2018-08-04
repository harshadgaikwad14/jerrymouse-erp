package com.erp.action.api.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.erp.action.api.model.Client;
import com.erp.common.wrapper.model.ClientWrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientTest {

	public static ClientWrapper getClientsById(long id) throws JsonParseException, JsonMappingException, IOException {
		final String uri = "http://localhost:8080/api/clients/" + id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
		ObjectMapper objectMapper = new ObjectMapper();
		ClientWrapper navigation = objectMapper.readValue(result, objectMapper.getTypeFactory().constructType(ClientWrapper.class));

		System.out.println(navigation);
		return navigation;

	}

	public static Client getClientByClientNameAndActive(String name, boolean active)
			throws JsonParseException, JsonMappingException, IOException {
		final String uri = "http://localhost:8080/api/clients/" + name + "/" + active;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
		ObjectMapper objectMapper = new ObjectMapper();
		Client navigation = objectMapper.readValue(result, objectMapper.getTypeFactory().constructType(Client.class));

		System.out.println(navigation);
		return navigation;

	}

	public static List<ClientWrapper> getAllClients() throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/clients";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(result.getStatusCodeValue());
		System.out.println(result.getBody());

		ObjectMapper objectMapper = new ObjectMapper();

		List<ClientWrapper> navigation = objectMapper.readValue(result.getBody(),
				objectMapper.getTypeFactory().constructCollectionType(List.class, ClientWrapper.class));

		return navigation;
	}

	public static void customHeader() {
		final String uri = "http://localhost:8080/api/clients";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(result);
	}

	public static ClientWrapper createClients() {
		final String uri = "http://localhost:8080/api/clients";

		ClientWrapper clientWrapper = new ClientWrapper();
		clientWrapper.setClientName("HSDFC");
		clientWrapper.setActive(true);
		RestTemplate restTemplate = new RestTemplate();
		ClientWrapper result = restTemplate.postForObject(uri, clientWrapper, ClientWrapper.class);

		return result;
	}

	private static void updateClients() throws JsonParseException, JsonMappingException, IOException {
		final String uri = "http://localhost:8080/api/clients/{id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		
		ClientWrapper clientWrapper = getClientsById(1);
		
		clientWrapper.setActive(false);
		clientWrapper.setClientName("AXIS");
	

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, clientWrapper, params);
	}

	private static void deleteClients(final long id) {
		final String uri = "http://localhost:8080/api/clients/{id}";

		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, params);
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		//System.out.println(createClients());
		//System.out.println(getAllClients());
		//updateClients();
		
		deleteClients(3);

		// Client c= getClientByClientNameAndActive("FNBO",true);
		// System.out.println(c);

	}

}
