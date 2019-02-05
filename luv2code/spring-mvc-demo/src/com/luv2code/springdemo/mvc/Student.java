package com.luv2code.springdemo.mvc;

import java.util.*;

public class Student {

	private String firstName;
	private String lastName;
	private String Country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private String operatingSystem;
	public Student() {
		// populate country options : used ISO country code
		countryOptions = new LinkedHashMap<>();

		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "United States");

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) { // on submit Spring will call student.setCountry()
		Country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystems) {
		this.operatingSystem = operatingSystems;
	}
	

}
