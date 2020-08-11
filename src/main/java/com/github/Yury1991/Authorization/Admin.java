package com.github.Yury1991.Authorization;


// Роль - администратор, имеет больше возможностей, чем пользователь
public class Admin extends Subject{		
	//----------Данные-----------------
	private  final String login ;		//логин
	private  final String password;	//пароль	
	
	Admin(){
		login = "admin";
		password = "admin";
	}
	
	
	public String getLogin() {		
		return login;
	}
	public String getPassword() {
		return password;
	}

	
	
		
	
	
	
}