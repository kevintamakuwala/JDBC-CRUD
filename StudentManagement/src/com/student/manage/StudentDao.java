package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB(Student student) {
		try {
			Connection con = ConnectionProvider.CreateConnection();
			String query = "insert into students(sname,sphone,scity) values(?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(query);

//			Setting values of parameters
			pstmt.setString(1, student.getStudentName());
			pstmt.setString(2, student.getStudentPhone());
			pstmt.setString(3, student.getStudentCity());

			pstmt.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void getStudentToDB() {
		try {
			Connection con = ConnectionProvider.CreateConnection();
			String query = "select * from students;";
			Statement stmt = con.createStatement();

			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt("sid");
				String name = resultSet.getString("sname");
				String phone = resultSet.getString("sphone");
				String city = resultSet.getString("scity");
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Phone: " + phone);
				System.out.println("City: " + city);
				System.out.println("----------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean updateStudentToDB(int sid, Student student) {

		try {
			Connection con = ConnectionProvider.CreateConnection();
			String query = "update students set sname = ?, sphone = ?, scity = ? where sid = ? ;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(4, sid);
			pstmt.setString(1, student.getStudentName());
			pstmt.setString(2, student.getStudentPhone());
			pstmt.setString(3, student.getStudentCity());
			pstmt.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean deleteStudentToDB(int id) {
		try {
			Connection con = ConnectionProvider.CreateConnection();
			String query = "delete from students where sid=?;";
			PreparedStatement pstmt = con.prepareStatement(query);

//			Setting id to delete

			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
