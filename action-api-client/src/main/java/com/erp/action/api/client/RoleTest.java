package com.erp.action.api.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.erp.action.api.model.Role;
import com.erp.common.wrapper.model.ClientWrapper;
import com.erp.common.wrapper.model.RoleWrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoleTest {

	public static RoleWrapper getrolesById(long id) throws JsonParseException, JsonMappingException, IOException {
		final String uri = "http://localhost:8080/api/roles/" + id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
		ObjectMapper objectMapper = new ObjectMapper();
		RoleWrapper navigation = objectMapper.readValue(result,
				objectMapper.getTypeFactory().constructType(RoleWrapper.class));

		System.out.println(navigation);
		return navigation;
	}

	public static Set<RoleWrapper> getRoles() throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/roles";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(result.getStatusCodeValue());
		System.out.println(result.getBody());

		ObjectMapper objectMapper = new ObjectMapper();

		Set<RoleWrapper> navigation = objectMapper.readValue(result.getBody(),
				objectMapper.getTypeFactory().constructCollectionType(Set.class, RoleWrapper.class));

		return navigation;
	}

	public static void customHeader() {
		final String uri = "http://localhost:8080/api/roles";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(result);
	}

	public static RoleWrapper createRoles() {
		final String uri = "http://localhost:8080/api/roles";

		RoleWrapper role = new RoleWrapper();
		role.setRoleName("Test");
		role.setActive(true);
		RestTemplate restTemplate = new RestTemplate();
		RoleWrapper result = restTemplate.postForObject(uri, role, RoleWrapper.class);

		return result;
	}

	private static void updateRoles(final long id) throws JsonParseException, JsonMappingException, IOException {
		final String uri = "http://localhost:8080/api/roles/{id}";

		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);

		RoleWrapper roleWrapper = getrolesById(id);
		
		roleWrapper.setActive(false);
		roleWrapper.setRoleName("TESTUPDATED");
	

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, roleWrapper, params);
	}

	private static void deleteRole(final long id) {
		final String uri = "http://localhost:8080/api/roles/{id}";

		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, params);
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		System.out.println(getRoles());
		//System.out.println(createRoles());
		//updateRoles(4l);
		System.out.println(getrolesById(1l));
		deleteRole(4);

	}

}
