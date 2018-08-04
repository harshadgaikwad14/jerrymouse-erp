package com.erp.action.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Created by Harshad on 24/06/2018.
 */
@Entity
@Table(name = "vendor_types",uniqueConstraints={
	    @UniqueConstraint(columnNames = {"type_name"})
	})
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "createdDate", "updatedDate" }, allowGetters = true, ignoreUnknown = true)

public class VendorType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="type_id")
	private long id;

	@NotBlank
	
	@Column(name="type_name")
	private String typeName;

	@NotBlank
	@Column(name="type_desc")
	private String typeDesc;
	
	
	@Column(name="is_active",nullable=false)
	private boolean active;

	@Column(nullable = false, updatable = false,name="created_Date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;

	@Column(nullable = false,name="updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public String getTypeDesc() {
		return typeDesc;
	}



	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
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



	


	@Override
	public String toString() {
		return "VendorType [id=" + id + ", typeName=" + typeName + ", typeDesc=" + typeDesc + ", active=" + active
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}



	public VendorType() {
		super();
		// TODO Auto-generated constructor stub
	}

}
