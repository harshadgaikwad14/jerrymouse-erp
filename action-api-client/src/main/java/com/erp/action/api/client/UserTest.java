package com.erp.action.api.client;

import java.io.IOException;
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
import com.erp.action.api.model.Client;
import com.erp.action.api.model.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class UserTest {
	
	public static void getUserById(long id) {
		final String uri = "http://localhost:8080/api/users/"+id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);

	}
	
	private static void getUser()
	{
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/users";
		
		// Try 1
		
		/*RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);*/
		
		
		// Try 2
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result.getStatusCodeValue());
		System.out.println(result.getBody());
	}
	
	public static void customHeader()
	{
		final String uri = "http://localhost:8080/api/users";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	public static void createUser() throws JsonParseException, JsonMappingException, IOException
	{
		final String uri = "http://localhost:8080/api/users";
		
	
		
		Client c=new Client();
		c.setActive(true);
		c.setClientName("FNBO");
		
		Address address=new Address();
		
		address.setAddressLine1("SUKH-Shanti CHS LTD");	
		address.setCity("Mumbai");
		address.setCountry("INDIA");
		address.setState("MH");
		address.setZipCode("400065");
		

		User user = new User();
		user.setActive(true);
		user.setClient(c);
		user.setAddress(address);
		user.setUserName("harshag123");
		user.setEmailId("test@gmail.com");
		user.setFirstName("Harshad");
		user.setLastName("Gaikwad");
		user.setMobileNumber("7208733078");
		user.setPhoneNumber("123456799");
		user.setUserPassword("Test@1323424");
		
		RestTemplate restTemplate = new RestTemplate();
		User result = restTemplate.postForObject( uri, user, User.class);

		//System.out.println(result);
	}
	
	private static void updateUser()
	{
		final String uri = "http://localhost:8080/api/users/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		User User = new User();
		User.setActive(true);
		User.setUserName("Harshad");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put ( uri, User, params);
	}
	
	private static void deleteUser()
	{
		final String uri = "http://localhost:8080/api/users/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete ( uri,  params );
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		createUser();

	}

}
