package com.wf.eh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventhandlerApplication {
	
	public static final String TOPIC_NAME = "tenistopic";

	public static void main(String[] args) {
		SpringApplication.run(EventhandlerApplication.class, args);
	}

}
