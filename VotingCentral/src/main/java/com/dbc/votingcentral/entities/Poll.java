package com.dbc.votingcentral.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "poll")
public class Poll implements Serializable {

	private static final long serialVersionUID = -5833607926667653767L;

	@Id
	@Column(name = "pollId", nullable = false)
	private String pollId;

	@Column(name = "title", nullable = true)
	private String title;
	
	@Column(name="description", nullable=true)
	private String description;

	@Column(name = "creationDate", nullable = false)
	private Timestamp creationDate;
	
	@Column(name="startDate", nullable=false)
	private Timestamp startDate;
	
	@Column(name="endDate", nullable = false)
	private Timestamp endDate;

	@PrePersist
	private void generateId() {
		this.pollId = UUID.randomUUID().toString();
		Calendar cal = Calendar.getInstance();
		this.creationDate = new Timestamp(cal.getTimeInMillis());
	}

	public String getPollId() {
		return pollId;
	}

	public void setPollId(String pollId) {
		this.pollId = pollId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

}
