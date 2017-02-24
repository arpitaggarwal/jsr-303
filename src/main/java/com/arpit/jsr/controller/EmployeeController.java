package com.arpit.jsr.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.jsr.property.editor.BigDecimalEditor;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void create() {
	}
}
