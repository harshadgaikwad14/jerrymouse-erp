package com.erp.action.api.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.erp.action.api.model.Address;
import com.erp.action.api.model.Vendor;
import com.erp.action.api.model.VendorType;

public class VendorTest {
	
	public static void getVendorById(long id) {
		final String uri = "http://localhost:8080/api/vendors/"+id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);

	}
	
	private static void getVendor()
	{
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/api/vendors";
		
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
		final String uri = "http://localhost:8080/api/vendors";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	public static void createVendor()
	{
		final String uri = "http://localhost:8080/api/vendors";
		
		Address a=new Address();
		a.setAddressLine1("Sukh-Shanti");
		a.setAddressLine2("");
		a.setAddressLine3("");
		a.setCity("Mumbai");
		a.setCountry("India");
		a.setState("Maharashatra");
		a.setZipCode("123456789");
		
		
		
		VendorType vt=new VendorType();
		vt.setActive(true);
		vt.setTypeName("VT 200");
		vt.setTypeDesc("Vt 200");

		Vendor vendor = new Vendor();
		vendor.setActive(true);
		vendor.setAddress(a);
		vendor.setVendorName("Vendor1");
		vendor.setVendorType(vt);
		vendor.setVendorNickName("Vendor1");
		vendor.setVendorGstNumber("123466");
		vendor.setContactPersonAlternatePhoneNo("");
		vendor.setContactPersonEmail("");
		vendor.setContactPersonMobile("");
		vendor.setContactPersonName("");
		vendor.setBankAccountNumber("");
		vendor.setBankBranchIfsc("");
		vendor.setBankBranchName("");
		vendor.setBankName("");
		
		
		
		RestTemplate restTemplate = new RestTemplate();
		Vendor result = restTemplate.postForObject( uri, vendor, Vendor.class);

		System.out.println(result);
	}
	
	private static void updateVendor()
	{
		final String uri = "http://localhost:8080/api/vendors/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		
		
		Vendor Vendor = new Vendor();
		
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put ( uri, Vendor, params);
	}
	
	private static void deleteVendor()
	{
		final String uri = "http://localhost:8080/api/vendors/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete ( uri,  params );
	}

	public static void main(String[] args) {
		createVendor();

	}

}
