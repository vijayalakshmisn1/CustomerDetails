package com.tap.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static String url="jdbc:mysql://localhost:3306/jee_info";
	private static String user="root";
	private static String psd="Viju@123";
	private static Connection con;

	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, psd);

		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
