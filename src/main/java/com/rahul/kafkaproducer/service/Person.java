package com.rahul.kafkaproducer.service;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@JsonPropertyOrder({"id", "firstName","lastName", "email", "profession" })
public class Person {

	
	@NotNull
    public Integer id;
    @Size(min=6)
	public String firstName;
	public String lastName;
	public String email;
	@NotNull
	public String profession;
	
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", profession=" + profession + "]";
	}
	
	
	
	
	
	
	
	
	

	
	
	

}