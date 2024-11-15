package com.learningApp.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	@JsonProperty("documentation_uri")
	private String documentation_uri;
	
	public String getMessage() {
		return message;
	}
	public String getDocumentation_uri() {
		return documentation_uri;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDocumentation_uri(String documentation_uri) {
		this.documentation_uri = documentation_uri;
	}
}
