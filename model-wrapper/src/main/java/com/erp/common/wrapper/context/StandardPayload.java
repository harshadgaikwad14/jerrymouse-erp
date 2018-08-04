package com.erp.common.wrapper.context;

import java.io.Serializable;

public class StandardPayload<T> implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String domainId;
    protected String channelId;
    protected String channelSeqId;
    protected String payloadType;
    protected String requestType;
    protected String domainSeqId;
    protected String serviceKey;
    protected String userAction;
    protected T payload;

   
}