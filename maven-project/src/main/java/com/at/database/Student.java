package com.at.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
/**
 * 
 */
public class Student {
	@Override
	public String toString() {
		return "Student []";
	}

	public static void printAllStudent() throws SQLException{
		try(Connection connection = DBConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from student");) {
		
		
		while(result.next() == true) {
			int rollno = result.getInt(1);
//			String roll = result.getString(1);
//			int roll2 = result.getInt("rollno");
			
			
			String studentName = result.getString(2);
			
			System.err.println(rollno + "\t" + studentName);
		}
		}finally {
			System.out.print("done");
		}
	}
	public static void main(String[] args) throws SQLException {
		printAllStudent();
	}

}
