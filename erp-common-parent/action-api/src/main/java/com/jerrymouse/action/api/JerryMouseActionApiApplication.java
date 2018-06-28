package com.jerrymouse.action.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JerryMouseActionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerryMouseActionApiApplication.class, args);
	}
}
