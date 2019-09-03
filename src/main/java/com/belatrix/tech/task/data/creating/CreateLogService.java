package com.belatrix.tech.task.data.creating;

/**
 * Interface for declare methods business logic.
 */
public interface CreateLogService {

	String createMessageLog(String message, boolean logError, boolean logWarning, boolean logMessage);
	int getSelectTypeLog(boolean logError, boolean logWarning, boolean logMessage);

}
