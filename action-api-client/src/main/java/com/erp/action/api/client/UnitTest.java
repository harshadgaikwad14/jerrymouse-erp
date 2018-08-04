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

import com.erp.action.api.model.Unit;

public class UnitTest {
	
	public static void getUnitById(long id) {
		final String uri = "http://localhost:8080/api/units/"+id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);

	}
	
	private static void getUnits()
	{
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/units";
		
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
		final String uri = "http://localhost:8080/api/units";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	public static void createNote()
	{
		final String uri = "http://localhost:8080/api/units";

		Unit unit = new Unit();
		unit.setUnitName("Unit 1");
		unit.setUnitDesc("Unit 1 Desc");
		RestTemplate restTemplate = new RestTemplate();
		Unit result = restTemplate.postForObject( uri, unit, Unit.class);

		System.out.println(result);
	}
	
	private static void updateNote()
	{
		final String uri = "http://localhost:8080/api/units/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		Unit unit = new Unit();
		unit.setUnitName("Unit 1");
		unit.setUnitDesc("Unit Teset  Desc");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put ( uri, unit, params);
	}
	
	private static void deleteNote()
	{
		final String uri = "http://localhost:8080/api/units/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete ( uri,  params );
	}

	public static void main(String[] args) {
		updateNote();

	}

}
