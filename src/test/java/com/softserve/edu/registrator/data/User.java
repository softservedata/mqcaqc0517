package com.softserve.edu.registrator.data;

public class User {

	private String firstname;
	private String lastname;
	private String email;
	private String login;
	private String password;
	private String community;
	//
	private String city;

	public User(String firstname, String lastname, String email,
			String login, String password, String community, String city) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.login = login;
		this.password = password;
		this.community = community;
		this.city = city;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getCommunity() {
		return community;
	}

	public String getCity() {
		return city;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
