package com.github.yury1991.authorization;

import java.util.ArrayList;
/** Класс Subject - предок классов: Admin и User*/
public abstract class Subject {
	
	/**массив для хранения пароля пользователя*/
	public static ArrayList<Subject>subjects = new ArrayList<Subject>();
	
	
	/**Логин*/
	private String login;
	/**Пароль*/
	private String password;
	
	/**Конструктор по умолчанию*/
	 Subject() {
		login = null;
		password = null;
	}
	 /**Конструктор с параметрами*/
	Subject(String login, String password){
		this.login = login;
		this.password = password;
	}
	
	/**Метод доступа*/
	public String getLogin() {
		return login;
	}
	/**Метод доступа*/
	public String getPassword() {
		return password;
	}
}
