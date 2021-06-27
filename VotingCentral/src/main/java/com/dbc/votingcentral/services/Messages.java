package com.dbc.votingcentral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Messages {

	@Autowired
	public Environment env;
	
	public String getMessage(String key) {
		return env.getProperty(key);
	}
}
