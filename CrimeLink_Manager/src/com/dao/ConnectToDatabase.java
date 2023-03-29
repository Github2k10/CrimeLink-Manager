package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectToDatabase {
	static Connection makeConnection() throws SQLException {
		ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");
		
		return DriverManager.getConnection(bundle.getString("url"), bundle.getString("username"), bundle.getString("password"));
	}
}
