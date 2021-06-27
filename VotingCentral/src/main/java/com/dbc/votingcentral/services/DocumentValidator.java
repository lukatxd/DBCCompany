package com.dbc.votingcentral.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class DocumentValidator {
	
	@Value("${documentValidator.uri}")
	private String validatorUri;
	
	private static WebClient webClient;
	
	public boolean isDocumentValid(String document) {
		
		boolean isValid=false;
		webClient = WebClient.create();
		final String requestString = validatorUri+document;
		try {
			JsonNode response = webClient.get().uri(requestString).retrieve().bodyToMono(JsonNode.class).block();
			final String status = response.findValue("status").textValue();
			if(AbilityToVoteEnum.ABLE_TO_VOTE.name().equals(status)) {
				isValid=true;
			}else if(AbilityToVoteEnum.UNABLE_TO_VOTE.name().equals(status)){
				isValid = false;
			}
		}catch(WebClientResponseException ex) {
			isValid=false;
		}
		return isValid;
	}

}
