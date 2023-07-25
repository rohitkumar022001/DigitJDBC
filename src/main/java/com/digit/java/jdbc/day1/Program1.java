/**
 * 
 */
package com.digit.java.jdbc.day1;

import java.sql.Connection;

import java.sql.Statement;
import java.sql.DriverManager;

/**
 * 
 */
public class Program1 {

	/**
	 * @param args
	 */
	public static Connection con;
	public static Statement stmt;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			// step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			// step 2
			String url = "jdbc:mysql://localhost:3306/test2";
			String user = "root";
			String password = "Welcome@123";
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Connection Established");
				// step 3
				String sql = "create database jdbcTest";
				// step 4
				stmt = con.createStatement();
				// step 5
				stmt.executeUpdate(sql);
				System.out.println("Database Created");

			} else {
				System.out.println("Connection Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// step 6
			stmt.close();
			con.close();
			
		}

	}

}
