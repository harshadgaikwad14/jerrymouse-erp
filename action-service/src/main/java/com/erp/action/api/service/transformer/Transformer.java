package com.erp.action.api.service.transformer;

public interface Transformer<I,O> 
{
	
	public O transform(I input, O output);
	

}
