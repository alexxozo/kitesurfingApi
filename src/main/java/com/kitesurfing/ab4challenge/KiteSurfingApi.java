package com.kitesurfing.ab4challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class KiteSurfingApi {
	public static void main(String[] args) {
		SpringApplication.run(KiteSurfingApi.class, args);
	}
}
