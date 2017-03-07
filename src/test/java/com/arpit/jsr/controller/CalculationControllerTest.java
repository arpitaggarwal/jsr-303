package com.arpit.jsr.controller;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@ContextConfiguration(classes = { CalculationControllerTest.Config.class })
@RunWith(SpringRunner.class)
public class CalculationControllerTest {

	@Autowired
	private CalculationController calculationController;

	@Test
	public void validates_all_parameters_are_sest() throws Exception {
		assertThatExceptionOfType(ConstraintViolationException.class)
				.isThrownBy(
						() -> calculationController.calculate(null, 1.0, 1.0))
				.matches(e -> e.getConstraintViolations().size() == 1);
	}
	
	@Configuration
	public static class Config {

		@Bean
		public MethodValidationPostProcessor methodValidationPostProcessor() {
			return new MethodValidationPostProcessor();
		}

		@Bean
		public CalculationController calculationController() {
			return new CalculationController();
		}
	}

}
