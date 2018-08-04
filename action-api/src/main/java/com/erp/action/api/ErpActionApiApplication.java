package com.erp.action.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ErpActionApiApplication {
	
protected final Log logger = LogFactory.getLog(getClass());
	
	/*@Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
	    FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new RequestResponseLoggingFilter());
	    //registrationBean.addUrlPatterns("/vendors");
	    
	    
	         
	    return registrationBean;    
	}
	
	@Bean
	public FilterRegistrationBean<TransactionFilter> transactionFilter(){
	    FilterRegistrationBean<TransactionFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new TransactionFilter());
	    //registrationBean.addUrlPatterns("/vendors");
	    
	    
	         
	    return registrationBean;    
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ErpActionApiApplication.class, args);
	}
}
