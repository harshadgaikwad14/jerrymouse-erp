package com.erp.common.wrapper.context;

import java.io.Serializable;
import java.util.List;

public class StandardResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// "200" - Success, "422" - Validation error, "504" - Timeout, "5xx" - Other
	// errors
	protected String resCode;
	protected String resMsg;
	protected String devMsg;
	// to return new seq Id generated at API Channel
	protected String channelSeqId;
	// to be populated when resCode = "422"
	protected List<ValidationError> valErrors;
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getDevMsg() {
		return devMsg;
	}
	public void setDevMsg(String devMsg) {
		this.devMsg = devMsg;
	}
	public String getChannelSeqId() {
		return channelSeqId;
	}
	public void setChannelSeqId(String channelSeqId) {
		this.channelSeqId = channelSeqId;
	}
	public List<ValidationError> getValErrors() {
		return valErrors;
	}
	public void setValErrors(List<ValidationError> valErrors) {
		this.valErrors = valErrors;
	}
	@Override
	public String toString() {
		return "StandardResponse [resCode=" + resCode + ", resMsg=" + resMsg + ", devMsg=" + devMsg + ", channelSeqId="
				+ channelSeqId + ", valErrors=" + valErrors + "]";
	}

	
}