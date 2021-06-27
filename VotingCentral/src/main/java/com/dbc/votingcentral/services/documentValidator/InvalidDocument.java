package com.dbc.votingcentral.services.documentValidator;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;

public class InvalidDocument extends VoterDocumentStatus {

	@Override
	public ResponseEntity<JSONObject> getResponse(){
		return ResponseEntity.notFound().build();
	}
}
