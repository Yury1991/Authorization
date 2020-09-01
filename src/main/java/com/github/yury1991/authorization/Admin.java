package com.github.yury1991.authorization;


/** Класс - администратор,  <br>
 * Наследован от класса Subject {@link Subject} <br>
 * Паттер проектирования - Singleton */

public class Admin extends Subject{		
	/**логин администратора*/
	private static final String LOGIN = "admin" ;	
	
	/**пароль администратора*/	
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