package com.github.Yury1991.Authorization;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connect {
	public Connection getConnection()throws SQLException;				//подключиться к БД
	public void disconnect(Connection connection)throws SQLException;	//отключиться от БД
}
