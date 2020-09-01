package com.github.yury1991.authorization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**Класс, реализующий интерфейс Connect {@link Connect}*/
public class Connecting implements Connect {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(Connecting.class); 
	
	public  Connection conn ;
	
	/**Конструктор по умолчанию*/
	Connecting() throws SQLException{
		conn = getConnection();
	}
	/**{@link Connect#getConnection()}*/
	@Override
	public Connection getConnection() throws SQLException {
		final String URL = "jdbc:postgresql://localhost/authorization_db?serverTimezone=Europe/Moscow&useSSL=false";
		final String USER_NAME = "postgres";
		final String PASSWORD = "postgres";  
		try {
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();	 					                 
			logger.debug("Connection to Store DB succesfull!");						 
		}
		catch(Exception ex){			
			ex.printStackTrace();
			logger.debug(ex.getMessage());
		}	
		return DriverManager.getConnection(URL, USER_NAME, PASSWORD);		
	}

	/**{@link Connect#disconnect(Connection)}*/
	@Override
	public void disconnect(Connection connection) throws SQLException {
		if(connection != null) {
			connection.close();
		}
		else {
			return;
		}
		
	}

}
