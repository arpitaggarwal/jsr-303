package com.arpit.jsr.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arpit.jsr.model.CalculationResult;

@Validated
@Controller
public class CalculationController {

	@RequestMapping(value = "/calculate")
	@ResponseBody
	public CalculationResult calculate(
			@Valid @NotBlank @RequestParam(name = "operation") String operation,
			@Valid @NotNull @RequestParam(name = "num1") Double num1,
			@Valid @NotNull @RequestParam(name = "num2") Double num2) {
		System.out.print("Operation:" + operation);

		return new CalculationResult(operation);
	}
}
