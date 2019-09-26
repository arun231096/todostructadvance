package com.struct.todo.app.model;

import org.apache.struts.action.ActionForm;

/**
 * @author arunkumar.angappan
 *
 */
public class SignUpForm extends ActionForm{
	private static final long serialVersionUID = 3368623357983494310L;

	private String username;
	private String password;
	private String designation;
	private String email;
	private String mobile;

	public final String getUsername() {
		return username;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final String getDesignation() {
		return designation;
	}
	public final void setDesignation(String designation) {
		this.designation = designation;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getMobile() {
		return mobile;
	}
	public final void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
