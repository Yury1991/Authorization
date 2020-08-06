package com.github.Yury1991.Authorization;

public class SQL {
		public static final String INSERT = "INSERT INTO auth_table (login, pass) VALUES (?, ?)";
		public static final String CHANGE = "INSERT INTO auth_table (login, pass)"
				+ " VALUES (?,?) WHERE login = ?";
		public static final String SELECT = "SELECT (login, pass) FROM "
				+ "auth_table WHERE login = ? AND pass = ?";
		public static final String SHOW = "SELECT * FROM auth_table";
		public static final String DELETE = "DELETE (login, pass) FROM auth_table WHERE login = ?";		
}
