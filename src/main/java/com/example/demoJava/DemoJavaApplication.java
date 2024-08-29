package com.example.demoJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJavaApplication.class, args);
	}

}
