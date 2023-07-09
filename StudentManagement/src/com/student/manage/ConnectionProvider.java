package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;

	public static Connection CreateConnection() {

		try {
//			Loading The driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
