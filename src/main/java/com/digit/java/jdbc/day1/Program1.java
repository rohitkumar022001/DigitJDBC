/**
 * 
 */
package com.digit.java.jdbc.day1;

import java.sql.Connection;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 
 */
public class Program1 {

	/**
	 * @param args
	 */
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static int row;
	public static int x;

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
				//String sql = "create database jdbcTest";
				//String sql="create table Student(id int,name varchar(60),school varchar(60),fname varchar(60),lname varchar(60))";
				//String sql = "insert into Student values(1,'rohit','digit','rohit','kumar')";
				String sql = "insert into Student values(?,?,?,?,?)";
				// step 4
				// stmt = con.createStatement(); 1st create
				  pstmt=con.prepareStatement(sql);
				  Scanner sc=new Scanner(System.in);
				  System.out.println("Enter number of row you want to create : ");
				  row=sc.nextInt();
				  for(int i=0;i<row;i++) {
					  System.out.println("enter row number : "+(i+1));
				  System.out.println("ente the student id : ");
				  pstmt.setInt(1,sc.nextInt());
				  System.out.println("ente the student name : ");
				  pstmt.setString(2,sc.next());
				  System.out.println("ente the student school : ");
				  pstmt.setString(3,sc.next());
				  System.out.println("ente the student fname : ");
				  pstmt.setString(4,sc.next());
				  System.out.println("ente the student lname : ");
				  pstmt.setString(5,sc.next());
				  x=pstmt.executeUpdate();
				  }
				  
				// step 5
				//stmt.executeUpdate(sql); 
				
				if(x>0) {
					System.out.println("data added");
				}
				else {
					System.out.println("failed data addition");
				}
				//System.out.println("Database Created");
				System.out.println("Student Table Created");

			} else {
				System.out.println("Connection Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/*finally {
			// step 6
			stmt.close();
			con.close();
			pstmt.close();
			
		}*/

	}

}
