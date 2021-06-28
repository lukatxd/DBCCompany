package com.dbc.votingcentral.services.documentValidator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;

public class ValidAndAbleToVote extends VoterDocumentStatus{

	public ValidAndAbleToVote() {
		this.abilityToVote = AbilityToVote.ABLE_TO_VOTE;
	}
	
	@Override
	public ResponseEntity<JSONObject> getResponse(){
		Map<String, String> abilityToVoteMap = new HashMap<>();
		abilityToVoteMap.put("status", abilityToVote.name());
		JSONObject j = new JSONObject(abilityToVoteMap);
		return ResponseEntity.ok().body(j);
	}

}
