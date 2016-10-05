package com.arpit.jsr.controller;

import java.util.HashSet;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.arpit.jsr.model.PersonForm;
import com.arpit.jsr.validator.PersonValidator;

@Controller
// @Validated results in ConstraintViolationException
@Validated
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
	@ResponseStatus(HttpStatus.OK)
	// @Valid annotation results in MethodArgumentNotValidException
	public String checkPersonInfo(@Valid PersonForm personForm,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		personValidator.validate(personForm, bindingResult);
		if (bindingResult.hasErrors()) {
			throw new ConstraintViolationException(new HashSet<>());
		}
		return "redirect:/results";
	}
}