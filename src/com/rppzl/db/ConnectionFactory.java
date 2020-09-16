package com.rppzl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/rppzl?useSSL=false";
	private static final String user = "rppzl";
	private static final String pass = "rppzl";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, user, pass);
	}
}
