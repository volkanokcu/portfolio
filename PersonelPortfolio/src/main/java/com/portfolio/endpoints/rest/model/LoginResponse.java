package com.portfolio.endpoints.rest.model;

public class LoginResponse {
    
	private String username;
	private String token;
    private String status;

    public LoginResponse(String username, String token, String status) {
    	this.username = username;
    	this.token = token;
    	this.status = status;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
	
}
