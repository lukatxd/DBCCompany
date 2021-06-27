package com.dbc.votingcentral.dto;

public class DocumentValidatorDTO {
	private boolean canVote;
	private boolean isValid;
	private String status;

	public boolean canVote() {
		return canVote;
	}

	public void setCanVote(boolean canVote) {
		this.canVote = canVote;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
