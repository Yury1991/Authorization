package com.github.Yury1991.Authorization;

import java.io.IOException;
import java.sql.SQLException;

public interface Dao {
	
	public void create(User user)throws SQLException, IOException; // создать пользователя
	
	public boolean check(User user)throws SQLException, IOException; // проверить данные
	
	public void change(User user)throws SQLException, IOException;  // изменить пароль
	
	public void show()throws SQLException, IOException;				// посмотреть бд
	
	public void delete(User user)throws SQLException, IOException;	//удалить учетную запись
}

/*
 * 
 * public boolean check(User user) throws SQLException, IOException
 * public void change(User user) throws SQLException, IOException
 * public void show() throws SQLException, IOException
 * public void userDelete(User user) throws SQLException, IOException 
 * 
 * */
