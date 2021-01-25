package com.example.app.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Request {

	@NotBlank(message = "featureName is required")
	private String featureName;
	
	@NotBlank(message = "email is required")
	@Email(message = "Email is invalid")
	private String email;
	
	@NotNull(message = "enable is required")
	private Boolean enable;
	
	public Request() {
	}
	
	public String getFeatureName() 
	{
		return this.featureName;
	}
	
	public String getEmail() 
	{
		return this.email;
	}
	
	public Boolean getEnable() 
	{
		return this.enable;
	}
	
	
	@Override
	public String toString() 
	{
		return "{" + "featureName=" + this.getFeatureName() + ", email='" + this.getEmail() + '\'' + ", enable='" + this.getEnable() + '\'' + '}';
	}
}
