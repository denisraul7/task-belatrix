package com.belatrix.tech.task.data.logging;

import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingFile extends LogsManagement {

	private String message;
	private Map parameters;
	private Logger logger;

	public LoggingFile(String message, Map parameters, Logger logger) {
		this.message = message;
		this.parameters = parameters;
		this.logger = logger;
	}

	@Override
	public void insertLogs(){
		System.out.println("operation logs initializer..");
		try {
			FileHandler fileHandler = new FileHandler(parameters.get("logFileFolder") + "/logFile.txt");
			logger.addHandler(fileHandler);
			logger.log(Level.INFO, message);
		} catch (IOException e) {
			System.out.println("Failed interruption exception");
		}
	}

}
