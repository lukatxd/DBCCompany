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

	@Column(name = "durationInMinutes", nullable = false)
	private Long durationInMinutes;

	@Column(name="creationDate", nullable=false)
	private Timestamp creationDate;
	
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

	public Long getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(Long durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((durationInMinutes == null) ? 0 : durationInMinutes.hashCode());
		result = prime * result + ((pollId == null) ? 0 : pollId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Poll other = (Poll) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (durationInMinutes == null) {
			if (other.durationInMinutes != null)
				return false;
		} else if (!durationInMinutes.equals(other.durationInMinutes))
			return false;
		if (pollId == null) {
			if (other.pollId != null)
				return false;
		} else if (!pollId.equals(other.pollId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Poll [pollId=" + pollId + ", title=" + title + ", durationInMinutes=" + durationInMinutes
				+ ", creationDate=" + creationDate + "]";
	}

}
