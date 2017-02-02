package com.arpit.jsr.service;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import javax.validation.ConstraintDeclarationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.arpit.jsr.model.Address;

@ContextConfiguration(classes = { PersonServiceTest.Config.class })
@RunWith(SpringRunner.class)
public class PersonServiceTest {

	@Autowired
	private IPersonService personService;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testAddPerson() {
		expectedException.expect(ConstraintDeclarationException.class);
		personService.add(null, new Address());
	}

	@Test
	public void testAddPersonUsingAssertj() {
		assertThatExceptionOfType(ConstraintDeclarationException.class)
				.isThrownBy(() -> personService.add(null, new Address()));
	}

	@Configuration
	public static class Config {
		@Bean
		public MethodValidationPostProcessor methodValidationPostProcessor() {
			return new MethodValidationPostProcessor();
		}

		@Bean
		public IPersonService personService() {
			return new PersonServiceImpl();
		}
	}
}
