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
@Table(name = "status", uniqueConstraints = { @UniqueConstraint(columnNames = { "status_name" }) })
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "createdDate", "updatedDate" }, allowGetters = true, ignoreUnknown = true)

public class Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private long id;

	@NotBlank
	@Column(name = "status_name")
	private String statusName;

	@Column(name = "status_desc")
	private String statusDesc;

	@Column(nullable = false, updatable = false, name = "created_Date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;

	@Column(nullable = false, name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", statusName=" + statusName + ", statusDesc=" + statusDesc + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
