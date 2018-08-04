package com.erp.action.api.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.erp.action.api.model.Address;
import com.erp.common.wrapper.model.AddressWrapper;

public class AddressTest {

	public static void getAddressById(long id) {
		final String uri = "http://localhost:8080/api/address/" + id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);

	}

	private static void getAddress() {
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/address";

		// Try 1

		/*
		 * RestTemplate restTemplate = new RestTemplate(); String result =
		 * restTemplate.getForObject(uri, String.class);
		 */

		// Try 2
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(result.getStatusCodeValue());
		System.out.println(result.getBody());
	}

	public static void customHeader() {
		final String uri = "http://localhost:8080/api/address";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(result);
	}

	public static void createAddress() {
		final String uri = "http://localhost:8080/api/address";

		AddressWrapper addressWrapper = new AddressWrapper();

		addressWrapper.setAddressLine1("addressLine1");
		addressWrapper.setAddressLine2("addressLine2");
		addressWrapper.setAddressLine3("addressLine3");
		addressWrapper.setCity("city");
		addressWrapper.setCountry("country");
		addressWrapper.setState("state");
		addressWrapper.setZipCode("zipCode");
		RestTemplate restTemplate = new RestTemplate();
		AddressWrapper result = restTemplate.postForObject(uri, addressWrapper, AddressWrapper.class);

		System.out.println(result);
	}

	private static void updateAddress() {
		final String uri = "http://localhost:8080/api/address/{id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		AddressWrapper addressWrapper = new AddressWrapper();
		addressWrapper.setId(1);
		addressWrapper.setAddressLine1("addressLine1");
		addressWrapper.setAddressLine2("addressLine2");
		addressWrapper.setAddressLine3("addressLine3");
		addressWrapper.setCity("city");
		addressWrapper.setCountry("country");
		addressWrapper.setState("state");
		addressWrapper.setZipCode("zipCode");

		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.put(uri, addressWrapper, params);
	}

	private static void deleteNote() {
		final String uri = "http://localhost:8080/api/address/{id}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, params);
	}

	public static void main(String[] args) {
		getAddressById(1);

	}

}
