package com.github.yury1991.authorization;


/** Роль - администратор, имеет больше возможностей, чем пользователь. <br>
 * Паттер проектирования - Singleton */

public class Admin extends Subject{		
	/**логин*/
	private static final String LOGIN = "admin" ;	
	
	/**пароль*/	
	private  static final String PASSWORD = "admin";	
	
	/**Конструктор*/	
	private Admin(){
		
	}
	
	/** Фабрика создания Admin*/
	private static class AdminSingletonHolder {
		static Admin instance = new Admin();
	}
	
	/** @return возвращает экземпляр Admin*/ 
	public static Admin getInstance() {
		return AdminSingletonHolder.instance;
	}	
	/** @return возвращает логин*/ 
	public  String getLogin() {
		return LOGIN;
	}
	
	/** @return возвращает пароль*/ 
	public  String getPassword() {
		return PASSWORD;
	}
}