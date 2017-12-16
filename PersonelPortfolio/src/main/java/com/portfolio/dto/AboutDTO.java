package com.portfolio.dto;

public class AboutDTO {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String description;

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
