package com.dbc.votingcentral.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="vote")
public class Vote implements Serializable{

	private static final long serialVersionUID = 4948366577541328075L;
	
	
	
	@Id
	@Column(name="voteId", nullable=false)
	private String voteId;
	
	@Column(name="userDocument", nullable=false)
	private String userDocument;
	
	@Column(name="choice", nullable=false)
	private boolean choice;
	
	@ManyToOne
	@JoinColumn(name="pollId",nullable=false)
	private Poll pollId;
	
	@Column(name="voteTime", nullable=false)
	private Timestamp voteTime;
	
	public Vote(Poll poll, String document, String choice) {
		this.pollId = poll;
		this.userDocument = document;
		this.choice = Boolean.valueOf(choice);
	}

	@PrePersist
	private void generateId() {
		this.voteId = UUID.randomUUID().toString();
		this.voteTime = new Timestamp(new Date().getTime());
	}

	public String getVoteId() {
		return voteId;
	}

	public void setVoteId(String voteId) {
		this.voteId = voteId;
	}

	public String getUserDocument() {
		return userDocument;
	}

	public void setUserDocument(String userDocument) {
		this.userDocument = userDocument;
	}

	public boolean isChoice() {
		return choice;
	}

	public void setChoice(boolean choice) {
		this.choice = choice;
	}

	public Timestamp getVoteTime() {
		return voteTime;
	}

	public void setVoteTime(Timestamp voteTime) {
		this.voteTime = voteTime;
	}

	public Poll getPollId() {
		return pollId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (choice ? 1231 : 1237);
		result = prime * result + ((pollId == null) ? 0 : pollId.hashCode());
		result = prime * result + ((userDocument == null) ? 0 : userDocument.hashCode());
		result = prime * result + ((voteId == null) ? 0 : voteId.hashCode());
		result = prime * result + ((voteTime == null) ? 0 : voteTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		if (choice != other.choice)
			return false;
		if (pollId == null) {
			if (other.pollId != null)
				return false;
		} else if (!pollId.equals(other.pollId))
			return false;
		if (userDocument == null) {
			if (other.userDocument != null)
				return false;
		} else if (!userDocument.equals(other.userDocument))
			return false;
		if (voteId == null) {
			if (other.voteId != null)
				return false;
		} else if (!voteId.equals(other.voteId))
			return false;
		if (voteTime == null) {
			if (other.voteTime != null)
				return false;
		} else if (!voteTime.equals(other.voteTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", userDocument=" + userDocument + ", choice=" + choice + ", pollId=" + pollId
				+ ", voteTime=" + voteTime + "]";
	}
	
	

}
