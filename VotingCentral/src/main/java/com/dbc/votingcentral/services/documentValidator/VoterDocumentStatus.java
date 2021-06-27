package com.dbc.votingcentral.services.documentValidator;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;

import com.dbc.votingcentral.dto.DocumentValidatorDTO;

public abstract class VoterDocumentStatus {
	
	public abstract ResponseEntity<JSONObject> getResponse();
	protected AbilityToVote abilityToVote;
	
	public static VoterDocumentStatus resolveVoterStatus(DocumentValidatorDTO documentDto) {
		if(!documentDto.isValid()) {
			return new InvalidDocument();
		}else {
			if(documentDto.canVote()) {
				return new ValidAndAbleToVote();
			}else {
				return new ValidAndUnableToVote();
			}
		}
	}

	public AbilityToVote getAbilityToVote() {
		return abilityToVote;
	}
}
