package com.github.yury1991.authorization;

import java.io.IOException;
import java.sql.SQLException;

public interface Dao {
	/**Создать пользователя*/
	public void create(User user)throws SQLException, IOException; 
	
	/**Проверить данные */
	public boolean check(User user)throws SQLException, IOException; 
	
	/**Изменить пароль */
	public void change(User user)throws SQLException, IOException;   
	
	/**Посмотреть бд */
	public void show()throws SQLException, IOException;			
	
	/**Удалить учетную запись */
	public void delete(User user)throws SQLException, IOException;	
}

