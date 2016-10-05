package com.arpit.jsr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.arpit.jsr.controller",
		"com.arpit.jsr.validator", "com.arpit.jsr.exception.handler" })
public class ApplicationConfig extends WebMvcConfigurerAdapter {

}
