package com.github.yury1991.authorization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connecting implements Connect {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(Connecting.class); 
	public  Connection conn ;
	
	Connecting() throws SQLException{
		conn = getConnection();
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		final String URL = "jdbc:postgresql://localhost/authorization_db?serverTimezone=Europe/Moscow&useSSL=false";
		final String USER_NAME = "postgres";
		final String PASSWORD = "postgres";  
		try {
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();	 					                 
			System.out.println("Connection to Store DB succesfull!");						 
		}
		catch(Exception ex){
			System.out.println("Connection failed...");             
			System.out.println(ex);
			ex.printStackTrace();
			logger.debug(ex.getMessage());
		}	
		return DriverManager.getConnection(URL, USER_NAME, PASSWORD);		
	}

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
