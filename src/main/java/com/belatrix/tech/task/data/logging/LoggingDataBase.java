package com.belatrix.tech.task.data.logging;

import com.belatrix.tech.task.data.connection.H2Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Class implement methods heredity of LogsManagement.
 * Using polymorphism.
 */
public class LoggingDataBase extends LogsManagement {

	private String message;
	private int typeLog;
	private Map parameters;


	public LoggingDataBase(String message, int typeLog, Map parameters) {
		this.message = message;
		this.typeLog = typeLog;
		this.parameters = parameters;
	}

	/**
	 * Method custom for logic specific of LoggingDataBase.
	 */
	@Override
	public void insertLogs(){
		System.out.println("operation logs initializer..");
		Statement statement = null;

		H2Connection connection = new H2Connection();

		try {
			statement = connection.newConnection(parameters);
			statement.executeUpdate("insert into Log_Values('" + message + "', " + typeLog + ")");
		} catch (SQLException e) {
			System.out.println("Failed connection error!");
		}
	}

}
