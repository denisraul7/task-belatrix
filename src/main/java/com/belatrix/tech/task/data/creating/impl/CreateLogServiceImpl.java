package com.belatrix.tech.task.data.creating.impl;

import com.belatrix.tech.task.data.creating.CreateLogService;

import java.text.DateFormat;
import java.util.Date;

import static com.belatrix.tech.task.data.util.Constants.*;


public class CreateLogServiceImpl implements CreateLogService {

	/**
	 * Method validate process the creation message by logging type.
	 * @param message message.
	 * @param logError type error log.
	 * @param logWarning type warning log.
	 * @param logMessage type message log.
	 * @return String.class
	 */
	@Override
	public String createMessageLog(String message, boolean logError, boolean logWarning, boolean logMessage) {

		String newMessage = "";
		if (logMessage) {
			newMessage = newMessage + MESSAGE + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		}

		if (logError) {
			newMessage = newMessage + ERROR + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		}

		if (logWarning) {
			newMessage = newMessage + WARNING + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		}

		return newMessage;
	}

	/**
	 * Method return type log select.
	 * @param logError type error.
	 * @param logWarning type warning.
	 * @param logMessage type message.
	 * @return int.
	 */
	@Override
	public int getSelectTypeLog(boolean logError, boolean logWarning, boolean logMessage) {

		int t = 0;
		if (logMessage) {
			t = 1;
		}

		if (logError) {
			t = 2;
		}

		if (logWarning) {
			t = 3;
		}
		return t;
	}
}
