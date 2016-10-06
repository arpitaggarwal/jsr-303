package com.arpit.jsr.model;

import org.hibernate.validator.constraints.NotBlank;

public class Address {

	@NotBlank(message = "City should not be blank")
	private String city;

	private String country;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + "]";
	}
}
