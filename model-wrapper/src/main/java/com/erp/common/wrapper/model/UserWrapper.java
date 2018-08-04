package com.erp.common.wrapper.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


public class UserWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    private long id;
 
    
    private String userName;
    
   
    private String userPassword;
    
	
	private String firstName;

	
	private String middleName;

	
	
	private String lastName;

	
	
	private String mobileNumber;

	
	private String phoneNumber;

	
	
	private String emailId;
	
	
	
	private Set<RoleWrapper> roles;


	private AddressWrapper address;
    
 
	private boolean active;
    
 
    private ClientWrapper client;

	
	private Date createdDate;


	private Date updatedDate;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<RoleWrapper> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleWrapper> roles) {
		this.roles = roles;
	}

	public AddressWrapper getAddress() {
		return address;
	}

	public void setAddress(AddressWrapper address) {
		this.address = address;
	}

	public ClientWrapper getClient() {
		return client;
	}

	public void setClient(ClientWrapper client) {
		this.client = client;
	}

	
    

}
