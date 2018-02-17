package com.portfolio.endpoints.rest.model;

public class CustomResponse {
	
	private String status;
	
	public CustomResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
