package com.erp.common.wrapper.context;

import java.io.Serializable;

public class ValidationError implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String code;
    protected String field;
    public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ValidationError(String code, String field, String message) {
		super();
		this.code = code;
		this.field = field;
		this.message = message;
	}
	protected String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

   
    
}