package com.erp.action.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "vendors", uniqueConstraints = { @UniqueConstraint(columnNames = { "vendor_name" }) })
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "createdDate", "updatedDate" }, allowGetters = true, ignoreUnknown = true)
public class Vendor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	private long id;
	@NotBlank
	@Column(name = "vendor_name")
	private String vendorName;
	@Column(name = "vendor_nickName")
	private String vendorNickName;
	@Column(name = "vendor_gst_number")
	private String vendorGstNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendortype_id")
	private VendorType vendorType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	@Column(name = "contact_person_name")
	private String contactPersonName;
	@Column(name = "contact_person_email")
	private String contactPersonEmail;
	@Column(name = "contact_person_mobile")
	private String contactPersonMobile;
	@Column(name = "contact_person_alternate_phone_no")
	private String contactPersonAlternatePhoneNo;
	@Column(name = "bank_account_number")
	private String bankAccountNumber;
	@Column(name = "bank_branch_ifsc")
	private String bankBranchIfsc;
	@Column(name = "serviceRendered_goodsSupplied")
	private String serviceRenderedGoodsSupplied;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "bank_branch_name")
	private String bankBranchName;

	@Column(name = "is_active", nullable = false)
	private boolean active;

	@Column(nullable = false, updatable = false, name = "created_Date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;

	@Column(nullable = false, name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;

	public Vendor() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorNickName() {
		return vendorNickName;
	}

	public void setVendorNickName(String vendorNickName) {
		this.vendorNickName = vendorNickName;
	}

	public String getVendorGstNumber() {
		return vendorGstNumber;
	}

	public void setVendorGstNumber(String vendorGstNumber) {
		this.vendorGstNumber = vendorGstNumber;
	}

	public VendorType getVendorType() {
		return vendorType;
	}

	public void setVendorType(VendorType vendorType) {
		this.vendorType = vendorType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonMobile() {
		return contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}

	public String getContactPersonAlternatePhoneNo() {
		return contactPersonAlternatePhoneNo;
	}

	public void setContactPersonAlternatePhoneNo(String contactPersonAlternatePhoneNo) {
		this.contactPersonAlternatePhoneNo = contactPersonAlternatePhoneNo;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankBranchIfsc() {
		return bankBranchIfsc;
	}

	public void setBankBranchIfsc(String bankBranchIfsc) {
		this.bankBranchIfsc = bankBranchIfsc;
	}

	public String getServiceRenderedGoodsSupplied() {
		return serviceRenderedGoodsSupplied;
	}

	public void setServiceRenderedGoodsSupplied(String serviceRenderedGoodsSupplied) {
		this.serviceRenderedGoodsSupplied = serviceRenderedGoodsSupplied;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
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

}
