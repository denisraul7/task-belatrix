package com.belatrix.tech.task.data.validate.impl;

import com.belatrix.tech.task.data.validate.ValidateEntryService;

/**
 * Class of implements method the ValidateEntryService
 */
public class ValidateEntryServiceImpl implements ValidateEntryService {

	/**
	 * Mthod for validate parameters of input in exceptions.
	 * @param message  description.
	 * @param valueFileParam boolean.
	 * @param valueConsoleParam boolean.
	 * @param valueDataBaseParam boolean.
	 * @param valueMessageParam boolean.
	 * @param valueErrorParam boolean.
	 * @param valueWarningParam boolean.
	 * @throws Exception error.
	 */
	@Override
	public void validateValues(String message,
														 boolean valueFileParam,
														 boolean valueConsoleParam,
														 boolean valueDataBaseParam,
														 boolean valueMessageParam,
														 boolean valueErrorParam,
														 boolean valueWarningParam) throws Exception {

		if(message == null || message.trim().length() ==0){
			throw new Exception("Message cannot empty!");
		}

		if(!valueConsoleParam && !valueFileParam && !valueDataBaseParam){
				throw new Exception("Invalid configuration!");
		}

		if((!valueErrorParam && !valueMessageParam && !valueWarningParam)){
			 throw new Exception("Error or Warning or Message must be specified!");
		}

	}
}
