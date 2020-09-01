package com.github.yury1991.authorization;

import java.sql.Connection;
import java.sql.SQLException;
/**Интерфейс для выполнения подключения/отключения к/от БД*/
public interface Connect {
	/**подключиться к БД*/
	public Connection getConnection()throws SQLException;
	/**отключиться от БД*/
	public void disconnect(Connection connection)throws SQLException;	
}
