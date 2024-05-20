package com.api.kuspit_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.api.kuspit_b")
@EntityScan(basePackages = "com.api.kuspit_b.modelos")

//@SpringBootApplication
public class KuspitBApplication {

	public static void main(String[] args) {
		SpringApplication.run(KuspitBApplication.class, args);
	}

}
