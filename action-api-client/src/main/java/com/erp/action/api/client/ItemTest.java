package com.erp.action.api.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.erp.action.api.model.Item;
import com.erp.action.api.model.Grade;

public class ItemTest {
	
	public static void getItemById(long id) {
		final String uri = "http://localhost:8080/api/items/"+id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);

	}
	
	private static void getItems()
	{
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/items";
		
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
		final String uri = "http://localhost:8080/api/items";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	public static void createItem()
	{
		final String uri = "http://localhost:8080/api/items";
		
		Grade u1=new Grade();
		u1.setGradeName("Grade 4");
		u1.setActive(true);
		u1.setGradeDesc("Grade 4 Desc");
		
		Grade u2=new Grade();
		u2.setGradeName("Grade 5");
		u2.setActive(true);
		u2.setGradeDesc("Grade 5 Desc");
		
		Set<Grade> uSet=new HashSet<>();
		uSet.add(u1);
		uSet.add(u2);

		Item item = new Item();
		item.setItemName("Item 2");
		item.setItemDesc("Item 2 Desc");
		item.setActive(true);
		item.setGrades(uSet);
		
		RestTemplate restTemplate = new RestTemplate();
		Item result = restTemplate.postForObject( uri, item, Item.class);

		System.out.println(result);
	}
	
	private static void updateItem()
	{
		final String uri = "http://localhost:8080/api/items/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		Item Item = new Item();
		Item.setItemName("Item 1");
		Item.setItemDesc("Item Teset  Desc");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put ( uri, Item, params);
	}
	
	private static void deleteItem()
	{
		final String uri = "http://localhost:8080/api/items/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete ( uri,  params );
	}

	public static void main(String[] args) {
		createItem();

	}

}
