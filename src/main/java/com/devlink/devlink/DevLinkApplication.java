package com.devlink.devlink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DevLinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevLinkApplication.class, args);
	}

}

// CHANGE THE ALLOWED PORTS IN CORS CONFIG IF SWITCHING FROM DEV TO PRODUCTION PURPOSES
