package com.github.yury1991.authorization;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlDao implements Dao {

	private static final Logger logger 
	= LoggerFactory.getLogger(SqlDao.class);  // создание логгера, пока не работает
	public PreparedStatement preparedStatement;
	public Statement statement;
	public ResultSet resultSet;	
	SqlDao(){
		
	}

	@Override
	public void create(User user) throws SQLException, IOException {
		Connecting connecting = new Connecting();          
		try  {								 	
			preparedStatement = connecting.conn.prepareStatement(SQL.INSERT);									    
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());							        
			preparedStatement.executeUpdate();
			System.out.println("User created!");
			Subject.subjects.add(user);
		}	
		catch(Exception ex) {
			System.out.println("User cannot be created!");
			System.out.println(ex);
			ex.printStackTrace();
			logger.debug(ex.getMessage());
		}		
		connecting.disconnect(connecting.conn);
	}

	@Override
	public boolean check(User user) throws SQLException, IOException {
		boolean isFind = false;				//флаг поиска/проверки
		Connecting connecting = new Connecting();			 
		try  {	   
			PreparedStatement preparedStatement = connecting.conn.prepareStatement(SQL.SELECT);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());							    
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {						        
				System.out.println("Subject Found");
				isFind = true;					
				Subject.subjects.add(user);
				System.out.println("Subject - " + user.getLogin()+ " "+ user.getPassword() + " добавлен");
				System.out.println("Size of users list is " + Subject.subjects.size());
			}
			else {				
				System.out.println("Subject cannot be found!");
			}
		}catch(Exception ex) {			
			System.out.println("Subject cannot be found!");
			System.out.println(ex);
			ex.printStackTrace();
			logger.debug(ex.getMessage());
		}				
		connecting.disconnect(connecting.conn);
		return isFind; 
	}

	@Override
	public void change(User user) throws SQLException, IOException{
		 Connecting connecting = new Connecting();	
		 System.out.println("Try to change");
		 try  {							
			 PreparedStatement preparedStatement = connecting.conn.prepareStatement(SQL.CHANGE); 					
			 preparedStatement.setString(1, user.getPassword());	
			 preparedStatement.setString(2, user.getLogin());
			 preparedStatement.executeUpdate();
			 System.out.println("Password successfuly changed!");
		 }							       
		 catch(Exception ex) {
			 System.out.println("Password can't be changed!");
			 System.out.println(ex);
			 ex.printStackTrace();
			 logger.debug(ex.getMessage());
		 }
	}

	@Override
	public void show() throws SQLException, IOException {
		Connecting connecting = new Connecting();		       
		 try  {									    
			 preparedStatement = connecting.conn.prepareStatement(SQL.SHOW);	
			 statement = connecting.conn.createStatement();
			 resultSet = statement.executeQuery(SQL.SHOW);
			 while(resultSet.next()){
				 String login = resultSet.getString("login");
				 String pass = resultSet.getString("pass");					                   
				 System.out.printf("%s  %s   \n", login, pass);
			 }   			 
		 }							       
		 catch(Exception ex) {
			 System.out.println("User cannot be created!");
			 System.out.println(ex);
			 ex.printStackTrace();
			 logger.debug(ex.getMessage());
		 }
		 connecting.disconnect(connecting.conn);
	}

	@Override
	public void delete(User user)throws SQLException, IOException {
		 
		 Connecting connecting = new Connecting();	
		 System.out.println("Try to delete");
		 if(user.getLogin()!= Admin.getInstance().getLogin() && user.getPassword()!=Admin.getInstance().getPassword()) {
			 try  {							
				 PreparedStatement preparedStatement = connecting.conn.prepareStatement(SQL.DELETE); 					
				 preparedStatement.setString(1, user.getLogin());						 
				 preparedStatement.executeUpdate();
				 System.out.println("Account successfuly deleted!");
			 }							       
			 catch(Exception ex) {
				 System.out.println("Account can't be deleted!!");
				 System.out.println(ex);
				 ex.printStackTrace();
				 logger.debug(ex.getMessage());
			 }
		 }
		 connecting.disconnect(connecting.conn);
	}
}
