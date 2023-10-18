package com.pruebabackenddeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaBackendDeveloperApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8090");
		SpringApplication.run(PruebaBackendDeveloperApplication.class, args);
	}

}
