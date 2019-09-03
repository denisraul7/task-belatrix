package com.belatrix.tech.task.data.validate;

public interface ValidateEntryService {

	void validateValues(String message, boolean valueFileParam, boolean valueConsoleParam, boolean valueDataBaseParam,
											boolean valueMessageParam, boolean valueErrorParam, boolean valueWarningParam) throws Exception;

}
