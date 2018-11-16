                                                                                                                                                                                                                                                                                                                                           package com.model;

public class Registration {

	private String email;
	private long phoneNO;
	private Login Login;
	private int cost;
	
	public Registration(Login Login) {
		this.Login = Login;
	}

	public Registration(String email, int phoneNO, Login Login) {
		this.email = email;
		this.phoneNO = phoneNO;
		this.Login = Login;
	}

	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNO() {
		return phoneNO;
	}

	public void setPhoneNO(long phoneNO) {
		this.phoneNO = phoneNO;
	}

	public Login getLogin() {
		return Login;
	}

	public void setLogin(Login Login) {
		this.Login = Login;
	}

	public String getUsername() {
		return Login.getUsername();
	}

	public void setUsername(String username) {
		Login.setUsername(username);
	}

	public String getPassword() {
		return Login.getPassword();
	}

	public void setPassword(String password) {
		Login.setPassword(password);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
	
}
