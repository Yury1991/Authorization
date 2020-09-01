package com.github.yury1991.authorization;



/**Роль - пользователь, наследуесть от Subject*/
public class User extends Subject {
	/** Данные -------------------------------------------*/
	/**логин*/
	private String login;	
	/** пароль*/
	private String password;			// пароль
	
	
	/**Конструктор по умолчанию*/
	public User(){
		login = null;
		password = null;
	}

	/**Конструктор с параметрами*/	
	public User(String login, String password){
		this.login = login;
		this.password = password;
	}
	
	/** Методы доступа: -------------------------------------------------------------
	 * @return логин*/
	
	public String getLogin() {		
		return login;
	}
	
	public  void setLogin(String login) {		
		this.login = login;
	}
	
	/**@return пароль*/
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
	

}