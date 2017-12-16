package com.portfolio.security.login;

import com.portfolio.domain.impl.User;

public class LoginResponse {
    
	private String token;
    private String status;
    private User user;

    public LoginResponse(String token, User user, String status) {
        this.token = token;
        this.status = status;
        this.user = user;
    }

	public String getToken() {
		return token;
	}

	public String getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
