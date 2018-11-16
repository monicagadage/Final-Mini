                                                                                                                                                                                                                                                                                                                                           package com.model;

public class registration {

	private String email;
	private long phoneNO;
	private login login;
	private int cost;
	
	public registration(login login) {
		this.login = login;
	}

	public registration(String email, int phoneNO, login login) {
		this.email = email;
		this.phoneNO = phoneNO;
		this.login = login;
	}

	public registration() {
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

	public login getLogin() {
		return login;
	}

	public void setLogin(login login) {
		this.login = login;
	}

	public String getUsername() {
		return login.getUsername();
	}

	public void setUsername(String username) {
		login.setUsername(username);
	}

	public String getPassword() {
		return login.getPassword();
	}

	public void setPassword(String password) {
		login.setPassword(password);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
	
}
