package com.arpit.jsr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.arpit.jsr.model.PersonForm;
import com.arpit.jsr.validator.PersonValidator;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	@Autowired
	private PersonValidator personValidator;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		personValidator.validate(personForm, bindingResult);
		

		return "redirect:/results";
	}
}
