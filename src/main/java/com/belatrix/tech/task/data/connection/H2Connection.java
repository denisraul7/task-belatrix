package com.belatrix.tech.task.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

import static com.belatrix.tech.task.data.util.Constants.*;

public class H2Connection extends DataBaseConnection {

	@Override
	public Statement newConnection(Map parameters) {

		Connection connection;
		Properties properties = new Properties();

		String user = properties.getProperty("database.user");
		String password = properties.getProperty("database.password");
		String url = "jdbc:" + properties.getProperty("database.management") + "://" +
									properties.getProperty("database.server") + ":" + properties.getProperty("database.port") + "/";

		properties.put(USER_KEY, user);
		properties.put(PASSWORD_KEY, password);

		Statement st = null;

		try{
			connection = DriverManager.getConnection(url, properties);
			st = connection.createStatement();
		}catch (SQLException e){
			System.out.println("Failed connection to database");
		}

		return st;
	}
}
