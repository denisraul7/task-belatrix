package com.belatrix.tech.task.data.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class implement methods heredity of LogsManagement.
 * Using polymorphism.
 */
public class LoggingConsole extends LogsManagement {

	private String message;
	private Logger logger;

	public LoggingConsole(String message, Logger logger) {
		this.message = message;
		this.logger = logger;
	}

	/**
	 * Method custom for logic specific of LoggingConsole.
	 */
	@Override
	public void insertLogs(){
		System.out.println("operation logs initializer..");
		ConsoleHandler consoleHandler = new ConsoleHandler();
		logger.addHandler(consoleHandler);
		logger.log(Level.INFO, message);

	}

}
