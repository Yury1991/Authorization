package com.github.Yury1991.Authorization;
import java.io.NotSerializableException;
import java.io.Serializable;

//Роль - пользователь
public class User implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//----------Данные пользователя--------------------	
	private String login;				//логин
	private String password;			// пароль

	//----------Конструкторы ----------------------------
	public User(){
		login = null;
		password = null;			
	}

	public User(String login, String password){
		this.login = login;
		this.password = password;		
	}

	//-----------Методы доступа----------------------

	public String getLogin() {		
		return login;
	}
	public  void setLogin(String login) {		
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}