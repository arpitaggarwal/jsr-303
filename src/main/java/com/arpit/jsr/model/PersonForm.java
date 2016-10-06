package com.arpit.jsr.model;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

	@NotNull
	@Size(min = 2, max = 30)
	private String name;

	@NotNull(message = "Age should not be null")
	@Min(18)
	private Integer age;

	@Valid
	private Address address;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonForm [name=" + name + ", age=" + age + ", address="
				+ address + "]";
	}

}
