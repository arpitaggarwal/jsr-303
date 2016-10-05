package com.arpit.jsr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.arpit.jsr.model.PersonForm;

import static com.arpit.jsr.constants.ApplicationConstants.NAME_NOT_NULL;

@Component
public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PersonForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PersonForm person = (PersonForm) target;
		if (person.getName() == null || "hello".equals(person.getName())) {
			errors.rejectValue("name", NAME_NOT_NULL);
		}
	}

}
