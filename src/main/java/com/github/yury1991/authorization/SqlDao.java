package com.github.yury1991.authorization;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/** Функциональный класс реализующий интерфейс {@link Dao} */
public class SqlDao implements Dao {
	
	/**Логгер*/
	private static final Logger logger = LoggerFactory.getLogger(SqlDao.class);  
	
	/**Переменные для операций с базой данных:*/
	public PreparedStatement preparedStatement;
	public Statement statement;
	public ResultSet resultSet;	
	
	/**Конструктор по умолчанию*/
	SqlDao(){
		
		
	}
	
	/**Методы интерфейса: =======================================================*/
	
	/**@link {@link Dao#isAdmin(User)}*/
	@Override
	public boolean isAdmin(User user) {
		if(user.getLogin() == Admin.getInstance().getLogin() 
				 && user.getPassword()== Admin.getInstance().getPassword()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**@link {@link Dao#connectTemplate(User, String)}*/
	@Override
    public PreparedStatement connectTemplate(User user, String sql) 
    		throws SQLException, IOException{	
		
		Connecting connecting = new Connecting();
		preparedStatement = connecting.conn.prepareStatement(sql);
		
		if(sql!=SQL.DELETE) {												    
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());		
		}
		else {
			preparedStatement.setString(1, user.getLogin());
		}		
		return preparedStatement;
	}	
	
	@Override
    public ResultSet connectTemplate(String sql) 
    		throws SQLException, IOException{
		Connecting connecting = new Connecting();
		preparedStatement = connecting.conn.prepareStatement(sql);	
		statement = connecting.conn.createStatement();
		resultSet = statement.executeQuery(sql);
		return resultSet;
	}

	
	/**@link {@link Dao#catchException(Exception)}*/
	@Override
	public void catchException(Exception ex)throws SQLException, IOException{
		ex.printStackTrace();
		logger.debug(ex.getMessage());		
	}

	/**@link {@link Dao#create(User)}*/
	@Override
	public void create(User user) throws SQLException, IOException {		          
		try  {			
			preparedStatement = connectTemplate(user, SQL.INSERT);									        
			preparedStatement.executeUpdate();			
			Subject.subjects.add(user);
		}	
		catch(Exception ex) {
			catchException(ex);
		}	
	}

	/**@link {@link Dao#check(User)}*/
	@Override	
	public boolean check(User user) throws SQLException, IOException {
		/**Флаг поиска*/
		boolean isFind = false;				
					 
		try  {	   
			preparedStatement = connectTemplate(user, SQL.SELECT);										    
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {		        
				isFind = true;					
				Subject.subjects.add(user);				
			}
			else {		
				logger.debug("Subject cannot be found!");				
			}
		}catch(Exception ex) {			
			catchException(ex);
		}		
		return isFind; 
	}

	/**@link {@link Dao#change(User)}*/
	@Override
	public void change(User user) throws SQLException, IOException{	
		 try  {							
			 preparedStatement = connectTemplate(user, SQL.CHANGE);			 
			 preparedStatement.executeUpdate();			 
		 }							       
		 catch(Exception ex) {
			 catchException(ex);
		 }
	}

	/**@link {@link Dao#show()}*/
	@Override
	public void show() throws SQLException, IOException {		       
		 try  {   			 
			 resultSet = connectTemplate(SQL.SHOW);
			 while(resultSet.next()){
				 String login = resultSet.getString("login");
				 String pass = resultSet.getString("pass");	
				 logger.debug("%s  %s   \n", login, pass);				 
			 }   			 
		 }							       
		 catch(Exception ex) {
			 catchException(ex);
		 }		
	}

	/**@link {@link Dao#delete(User)}*/
	@Override
	public void delete(User user)throws SQLException, IOException {	 
		 
		 	if(!isAdmin(user)) {
		 		try  {							
					 preparedStatement = connectTemplate(user, SQL.DELETE);						 						 
					 preparedStatement.executeUpdate();		 
				 }							       
				 catch(Exception ex) {
					 catchException(ex);
				 }
		 	}
		 	else {
		 		logger.debug("Admin can't delete his account!");
		 	}	 
	}
}
