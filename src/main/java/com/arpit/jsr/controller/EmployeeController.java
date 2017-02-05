package com.arpit.jsr.controller;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.jsr.property.editor.BigDecimalEditor;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(
			@RequestParam("amount") @NumberFormat(pattern = "#.###,##") BigDecimal amount) {
		System.out.println(amount);
		return "index";
	}
}
