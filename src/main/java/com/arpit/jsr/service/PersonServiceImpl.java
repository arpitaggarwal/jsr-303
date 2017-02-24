package com.arpit.jsr.service;

import org.springframework.stereotype.Service;

import com.arpit.jsr.model.Address;

@Service
public class PersonServiceImpl implements IPersonService {

	@Override
	public Address add(String name, Address address) {
		System.out.println(name);
		return address;
	}

}