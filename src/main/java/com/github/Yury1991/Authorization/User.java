package com.github.Yury1991.Authorization;



//Роль - пользователь
public class User extends Subject {
	private String login;				//логин
	private String password;			// пароль
	
	public User(){
		login = null;
		password = null;
	}

	public User(String login, String password){
		this.login = login;
		this.password = password;
	}
	
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