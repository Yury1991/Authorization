package com.github.Yury1991.Authorization;

import java.util.ArrayList;

public abstract class Subject {
	
	public static ArrayList<Subject>subjects = new ArrayList<Subject>();
	
	private String login;
	private String password;
	
	 Subject() {
		login = null;
		password = null;
	}
	
	Subject(String login, String password){
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
}
