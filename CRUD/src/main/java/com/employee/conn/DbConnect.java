package com.employee.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private static Connection conn=null;
	
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_directory","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
