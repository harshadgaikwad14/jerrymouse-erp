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

import com.erp.action.api.model.Grade;
import com.erp.action.api.model.Unit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GradeTest {
	
	public static void getGradeById(long id) {
		final String uri = "http://localhost:8080/api/grades/"+id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);

	}
	
	private static void getGrades()
	{
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/grades";
		
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
		final String uri = "http://localhost:8080/api/grades";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	public static void createGrade() throws Exception
	{
		final String uri = "http://localhost:8080/api/grades";
		
		Unit u1=new Unit();
		u1.setUnitName("Unit 2");
		u1.setUnitDesc("Unit 2 Desc");
		
		Unit u2=new Unit();
		u2.setUnitName("Unit 3");
		u2.setUnitDesc("Unit 3 Desc");
		
		Set<Unit> uSet=new HashSet<>();
		uSet.add(u1);
		uSet.add(u2);

		Grade grade = new Grade();
		grade.setGradeName("Grade 1");
		grade.setGradeDesc("Grade 1 Desc");
		grade.setUnits(uSet);
		
		ObjectMapper mapper = new ObjectMapper();
	

		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(grade);
		System.out.println(jsonInString);
		
		
		RestTemplate restTemplate = new RestTemplate();
		Grade result = restTemplate.postForObject( uri, grade, Grade.class);

		System.out.println(result);
	}
	
	private static void updateGrade()
	{
		final String uri = "http://localhost:8080/api/grades/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		Grade Grade = new Grade();
		Grade.setGradeName("Grade 1");
		Grade.setGradeDesc("Grade Teset  Desc");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put ( uri, Grade, params);
	}
	
	private static void deleteGrade()
	{
		final String uri = "http://localhost:8080/api/grades/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete ( uri,  params );
	}

	public static void main(String[] args) throws Exception {
		createGrade();

	}

}
