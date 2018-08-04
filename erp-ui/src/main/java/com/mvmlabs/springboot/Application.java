package com.mvmlabs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Spring Source Tool Suite.
 * 
 * @author Mark Meany
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
	
    /*http://localhost:8080/home
    http://localhost:8080/greet?name=Mark
    http://localhost:8080/greet/Mark
*/
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
