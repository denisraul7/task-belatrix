package com.belatrix.tech.task.data.validate.impl;

import com.belatrix.tech.task.data.validate.ValidateEntryService;

public class ValidateEntryServiceImpl implements ValidateEntryService {

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
