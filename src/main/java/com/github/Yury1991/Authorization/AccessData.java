package com.github.Yury1991.Authorization;

import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccessData implements Serializable{	 //включение сериализации для записи данных
													//.txt файл
	
	private static final Logger logger 
	= LoggerFactory.getLogger(AccessData.class);  // создание логгера, пока не работает
	private  static final String SERIAL_PATH = "D:\\Programming\\JavaEE\\Authorization\\src\\main\\resources\\user.ser"; 	
	
	//--------------Управление базой данных ----------------------------
	public Connection getConnection() throws SQLException, IOException {    //метод для соединения с базой		        
		final String URL = "jdbc:postgresql://localhost/authorization_db?serverTimezone=Europe/Moscow&useSSL=false";
		final String USER_NAME = "postgres";
		final String PASSWORD = "admin1010";  
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
	
	//------------------Функциональные методы-----------------------------------------
	// 1.Создание пользователя
		 public void create(User user) throws SQLException, IOException { 		       		 
			 Connection conn = getConnection();          
			 try  {								 	
				 PreparedStatement preparedStatement = conn.prepareStatement(SQL.INSERT);									    
				 preparedStatement.setString(1, user.getLogin());
				 preparedStatement.setString(2, user.getPassword());							        
				 preparedStatement.executeUpdate();
				 System.out.println("User created!");
			 }	
			 catch(Exception ex) {
				 System.out.println("User cannot be created!");
				 System.out.println(ex);
				 ex.printStackTrace();
				 logger.debug(ex.getMessage());
			 }		
		 }
		 
		 // 2. Проверка пользователя --------------------------

		 public boolean check(User user) throws SQLException, IOException { 
			 boolean isFind = false;				//флаг поиска/проверки
			 Connection conn = getConnection();			 
			 try  {	   
				 PreparedStatement preparedStatement = conn.prepareStatement(SQL.SELECT);
				 preparedStatement.setString(1, user.getLogin());
				 preparedStatement.setString(2, user.getPassword());							    
				 ResultSet resultSet = preparedStatement.executeQuery();
				 if(resultSet.next()) {						        
					 System.out.println("User Found");
					 isFind = true;
				 }
				 else {
					 System.out.println("User cannot be found!");

				 }
			 }catch(Exception ex) {
				 System.out.println("User cannot be found!");
				 System.out.println(ex);
				 ex.printStackTrace();
				 logger.debug(ex.getMessage());
			 }					  
			 return isFind; 
		 }
		 
		 // 3. Изменение  пароля, роль - пользователь
		 public void change(User user) throws SQLException, IOException {
			 Connection conn = getConnection();			
			 try  {							
				 PreparedStatement preparedStatement = conn.prepareStatement(SQL.CHANGE); 
				 preparedStatement.setString(2, user.getPassword());							        
				 preparedStatement.executeUpdate();
				 System.out.println("Password successfuly changed!");
			 }							       
			 catch(Exception ex) {
				 System.out.println("User cannot be created!");
				 System.out.println(ex);
				 ex.printStackTrace();
				 logger.debug(ex.getMessage());
			 }
		 }               
		 
		 //4. Просмотр базы данных, роль - администратор
		 public void show() throws SQLException, IOException { 
			 Connection conn = getConnection();		       
			 try  {									    
				 PreparedStatement preparedStatement = conn.prepareStatement(SQL.SHOW);	
				 Statement statement = conn.createStatement();
				 ResultSet resultSet = statement.executeQuery(SQL.SHOW);
				 while(resultSet.next()){
					 String login = resultSet.getString("login");
					 String pass = resultSet.getString("pass");					                   
					 System.out.printf("%s  %s   \n", login, pass);
				 }						        
				 conn.close();
			 }							       
			 catch(Exception ex) {
				 System.out.println("User cannot be created!");
				 System.out.println(ex);
				 ex.printStackTrace();
				 logger.debug(ex.getMessage());
			 }
		 }	 	 
		 
		 //---------------------Сериализация---------------------------------

		 // 1. Сохранение данных пользователя, для будущих операций над ними
		 public void save(User user) throws IOException {
			 FileOutputStream outputStream = new FileOutputStream(SERIAL_PATH);
			 ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			 objectOutputStream.writeObject(user);
			 objectOutputStream.close();
		 }
		 // 2. Загрузка данных пользователя
		 public User load() throws IOException, ClassNotFoundException {
			 FileInputStream fileInputStream = new FileInputStream(SERIAL_PATH);
			 try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {				 
				 return ((User) objectInputStream.readObject());
			 }		     
		 }
		 // 3. Очистка файла сериализации
		 public void clean() { // файл сериализации должен очищаться после каждой загрузки
			 
			 
		 }

		
}
		        
		 	
		
	