package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final static String URL = "jdbc:mysql://localhost:3306/dndcampaign";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "M4g4z1neSh1j1nk0!";
	private static Connection connection;
	private static DBConnection instance;
	
	private DBConnection(Connection connection) {
		DBConnection.connection = connection;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
				System.out.println("Connection Successful");
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return DBConnection.connection;
	}
}
