package com.erp.common.wrapper.context;

import java.io.Serializable;

public class StandardRequestContext<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String domainId;
	private String channelId;
	private String channelSeqId;
	private String action;
	private String type;
	private String remarks;
	private String userId;
	private String serviceKey;
	private String userAction;
	private StandardPayload<T> standardPayload;
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getChannelSeqId() {
		return channelSeqId;
	}
	public void setChannelSeqId(String channelSeqId) {
		this.channelSeqId = channelSeqId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}
	public String getUserAction() {
		return userAction;
	}
	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}
	public StandardPayload<T> getStandardPayload() {
		return standardPayload;
	}
	public void setStandardPayload(StandardPayload<T> standardPayload) {
		this.standardPayload = standardPayload;
	}
    
    

    
}