package com.github.Yury1991.Authorization;

public class SQL {  
	    
		public static final String INSERT = "INSERT INTO auth_table (login, pass) VALUES (?, ?)";
		public static final String CHANGE = "UPDATE  auth_table "
				+ " SET pass = ? WHERE login = ?";
		public static final String SELECT = "SELECT (login, pass) FROM "
				+ "auth_table WHERE login = ? AND pass = ?";
		public static final String SHOW = "SELECT * FROM auth_table";
		public static final String DELETE = "DELETE  FROM auth_table WHERE login = ?";	
		
		
		
	
}
