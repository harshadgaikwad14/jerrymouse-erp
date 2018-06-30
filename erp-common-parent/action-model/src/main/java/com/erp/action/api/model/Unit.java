package com.erp.action.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Harshad on 24/06/2018.
 */
@Entity
@Table(name = "units", uniqueConstraints = { @UniqueConstraint(columnNames = { "unit_name" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdDate", "updatedDate" }, allowGetters = true, ignoreUnknown = true)

public class Unit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unit_id")
	private long id;

	@NotBlank

	@Column(name = "unit_name")
	private String unitName;

	@NotBlank
	@Column(name = "unit_desc")
	private String unitDesc;

	@Column(name = "is_active", nullable = false)
	private boolean active;
	
	
	@ManyToMany(mappedBy="units")
    private Set<Grade> grades = new HashSet<>();

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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitDesc() {
		return unitDesc;
	}

	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
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

	
	
	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Unit [id=" + id + ", unitName=" + unitName + ", unitDesc=" + unitDesc + ", active=" + active
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	

}
