package com.dbc.votingcentral.dto;

import org.springframework.lang.NonNull;

public class VoteDTO {

	@NonNull
	String document;
	@NonNull
	String choice;
	@NonNull
	String pollId;
	
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getPollId() {
		return pollId;
	}
	public void setPollId(String pollId) {
		this.pollId = pollId;
	}
	
}
