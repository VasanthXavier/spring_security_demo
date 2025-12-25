package com.vax.spring_security_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}
}
