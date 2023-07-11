package com.java.Form;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	public static Connection CreateConnection() throws Exception
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}		
		return con;
		
	}
}
