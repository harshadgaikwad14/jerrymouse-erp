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

import com.erp.action.api.model.Status;

public class StatusTest {
	
	public static void getStatusById(long id) {
		final String uri = "http://localhost:8080/api/status/"+id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);

	}
	
	private static void getStatus()
	{
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/status";
		
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
		final String uri = "http://localhost:8080/api/status";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	public static void createStatus()
	{
		final String uri = "http://localhost:8080/api/status";

		Status status = new Status();
		status.setStatusName("AUTHORIZED");
		status.setStatusDesc("AUTHORIZED");
		RestTemplate restTemplate = new RestTemplate();
		Status result = restTemplate.postForObject( uri, status, Status.class);

		System.out.println(result);
	}
	
	private static void updateStatus()
	{
		final String uri = "http://localhost:8080/api/status/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		Status Status = new Status();
		Status.setStatusName("Status 1");
		Status.setStatusDesc("Status Teset  Desc");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put ( uri, Status, params);
	}
	
	private static void deleteStatus()
	{
		final String uri = "http://localhost:8080/api/status/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete ( uri,  params );
	}

	public static void main(String[] args) {
		createStatus();

	}

}
