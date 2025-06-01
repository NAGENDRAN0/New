package com.App.HMS.dto;


public class UserModelDto {


	private String firstname;
	private String email;
	private String role;	
	private String pass;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public UserModelDto(String firstname, String email, String role, String pass) {
		super();
		this.firstname = firstname;
		this.email = email;
		this.role = role;
		this.pass = pass;
	}
	public UserModelDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
