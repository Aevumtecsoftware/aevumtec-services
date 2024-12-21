package com.aevum.tec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.aevum.tec")
@ComponentScan(basePackages = "com.aevum.tec")
public class AevumProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AevumProjectApplication.class, args);
	}

}
