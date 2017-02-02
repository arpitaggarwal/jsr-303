package com.arpit.jsr.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.arpit.jsr.model.Address;

@Service
@Validated
public class PersonServiceImpl implements IPersonService {

	@Override
	public Address add(@Valid @NotNull @Size(min = 1) String name,
			@Valid Address address) {
		System.out.println(name);
		return new Address();
	}

}