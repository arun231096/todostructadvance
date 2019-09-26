package com.struct.todo.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author arunkumar.angappan
 *
 */
public class DbConfig {

	private static String Url = "jdbc:sqlserver://192.168.8.199:1433; databaseName=AML_Training";
	private static String user = "sa";
	private static String password = "sql123";
	private static Connection connection;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	connection = DriverManager.getConnection(Url, user, password);
	return connection;
	}
}
