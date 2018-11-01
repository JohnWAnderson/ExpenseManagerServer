package com.jwa.api.payload.request;

import javax.validation.constraints.NotBlank;

/**
 * 
 * @author John Anderson
 * 
 * The request object to login to get jwt token
 */
public class LoginRequestObject {
	@NotBlank
	private String usernameOrEmail;

	@NotBlank
	private String password;

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
