package com.belatrix.tech.task.data.reference;

import com.belatrix.tech.task.data.creating.CreateLogService;
import com.belatrix.tech.task.data.logging.LoggingConsole;
import com.belatrix.tech.task.data.logging.LoggingDataBase;
import com.belatrix.tech.task.data.logging.LoggingFile;
import com.belatrix.tech.task.data.logging.LogsManagement;
import com.belatrix.tech.task.data.validate.ValidateEntryService;

import java.util.Map;
import java.util.logging.Logger;

public class JobLoggerFinal {

	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logToDatabase;

	private static boolean logMessage;
	private static boolean logWarning;
	private static boolean logError;


	//private boolean initialized; Eliminar codigo muerto, para un tener un codigo limpio.

	private static Map dbParams;
	private static Logger logger;

	private CreateLogService logService;
	private ValidateEntryService entryService;

	public JobLoggerFinal(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
												boolean logMessageParam, boolean logWarningParam, boolean logErrorParam, Map parameters,
												CreateLogService logService, ValidateEntryService entryService){
		logger = Logger.getLogger("NyLog");
		logError = logErrorParam;
		logMessage = logMessageParam;
		logWarning = logWarningParam;
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;
		dbParams = parameters;

		this.logService = logService;
		this.entryService = entryService;
	}

	public void logMessage(String message) throws Exception {

			//Validate message
			entryService.validateValues(message, logToConsole, logToFile,
					logToDatabase, logMessage, logError, logWarning);
			message = message.trim();

			String newMessageLog = logService.createMessageLog(message, logError, logWarning, logMessage);

			if(logToFile){
				LogsManagement log = new LoggingFile(newMessageLog, dbParams, logger);
				log.insertLogs();
			}

			if(logToConsole){
				LogsManagement log = new LoggingConsole(message, logger);
				log.insertLogs();
			}

			if(logToDatabase){
				int typeLog = logService.getSelectTypeLog(logError, logWarning, logMessage);
				LogsManagement log = new LoggingDataBase(message, typeLog, dbParams);
				log.insertLogs();
			}



	}











}
