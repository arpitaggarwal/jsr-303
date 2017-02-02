package com.arpit.jsr.model;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.HibernateValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.arpit.jsr.config.ApplicationConfig;
import com.arpit.jsr.model.PersonForm;

@SpringBootTest(classes = { ApplicationConfig.class })
@RunWith(SpringRunner.class)
public class PersonFormTest {

	private LocalValidatorFactoryBean localValidatorFactory;

	@Before
	public void setup() {
		localValidatorFactory = new LocalValidatorFactoryBean();
		localValidatorFactory.setProviderClass(HibernateValidator.class);
		localValidatorFactory.afterPropertiesSet();
	}

	@Test
	public void testPersonForm() {
		Set<ConstraintViolation<PersonForm>> constraintViolations = localValidatorFactory
				.validate(new PersonForm());
		Assert.assertTrue("Validation error", constraintViolations.size() == 1);
	}
}
