package com.belatrix.tech.task.data.creating;

public interface CreateLogService {

	String createMessageLog(String message, boolean logError, boolean logWarning, boolean logMessage);
	int getSelectTypeLog(boolean logError, boolean logWarning, boolean logMessage);

}
