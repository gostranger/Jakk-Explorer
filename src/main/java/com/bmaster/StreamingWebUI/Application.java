package com.bmaster.StreamingWebUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "Application.properties", ignoreResourceNotFound = true)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
