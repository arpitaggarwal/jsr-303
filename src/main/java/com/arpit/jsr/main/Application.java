package com.arpit.jsr.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.arpit.jsr.config" })
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

	}
}
