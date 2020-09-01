package com.github.yury1991.authorization;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**Интерфейс для работы с пользователем*/
public interface Dao {
	
	/**Создать нового пользователя*/
	public void create(User user)throws SQLException, IOException; 
	
	/** Проверка данных пользователя <br>
	 * @return  флаг поиска*/
	public boolean check(User user)throws SQLException, IOException; 
	
	/** Изменение пароля пользователя*/
	public void change(User user)throws SQLException, IOException;   
	
	/**Показать всю базу данных*/
	public void show()throws SQLException, IOException;			
	
	/**Удалить учетную запись */
	public void delete(User user)throws SQLException, IOException;	
	
	/**@return preparedStatement
	 * @link Dao#connectTemplate(User, String)*/
	public PreparedStatement connectTemplate(User user, String sql) 
			throws SQLException, IOException;	
	
	/**Метод поиска исключений*/
	public void catchException(Exception ex)throws SQLException, IOException;
	
	/**Перегрузка метода connectTemplate*/
	public ResultSet connectTemplate(String sql) throws SQLException, IOException;
	
	/**Проверка прав пользователя*/
	public boolean isAdmin(User user);
}

