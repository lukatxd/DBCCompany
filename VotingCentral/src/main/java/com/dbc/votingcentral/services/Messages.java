package com.dbc.votingcentral.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Messages {

	/*
	@Autowired
	public Environment env;
	
	public String getMessage(String key) {
		return env.getProperty(key);
	}
	*/
	
	@Value("${badRequest.createPoll.message}")
	private String badRequestCreatePollMessage;
	public String getBadRequestCreatePollMesage() {
		return badRequestCreatePollMessage;
	}
}
