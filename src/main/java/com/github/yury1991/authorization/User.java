package com.github.yury1991.authorization;


/**Класс пользователя, 
  наследован от класса Subject {@link Subject}*/
public class User extends Subject {
	/** Данные -------------------------------------------*/
	/**логин пользователя*/
	private String login;	
	/** пароль пользователя */
	private String password;			
	
	
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
	/**@return логин*/
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