package com.dbc.votingcentral.services.documentValidator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.dbc.votingcentral.dto.DocumentValidatorDTO;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class DocumentValidator {
	
	@Value("${documentValidator.uri}")
	private String validatorUri;
	
	private static WebClient webClient;
	
	public VoterDocumentStatus validateDocument(String document) {
		
		DocumentValidatorDTO dto = this.processDocument(document);
		VoterDocumentStatus voterStatus = VoterDocumentStatus.resolveVoterStatus(dto);
		return voterStatus;
	}
	
	private DocumentValidatorDTO processDocument(String document) {
		DocumentValidatorDTO dto = new DocumentValidatorDTO();
		webClient = WebClient.create();
		final String requestString = validatorUri+document;
		try {
			JsonNode response = webClient.get().uri(requestString).retrieve().bodyToMono(JsonNode.class).block();
			dto.setValid(true);
			final String status = response.findValue("status").textValue();
			dto.setStatus(status);
		}catch(WebClientResponseException ex) {
			dto.setCanVote(false);
			dto.setValid(false);
		}
		return dto;
	}

}
