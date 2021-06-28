package com.dbc.votingcentral.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Transient
	private int yesCount;
	@Transient
	private int noCount;

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

	public int getYesCount() {
		return yesCount;
	}

	public void setYesCount(int yesCount) {
		this.yesCount = yesCount;
	}

	public int getNoCount() {
		return noCount;
	}

	public void setNoCount(int noCount) {
		this.noCount = noCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, description, endDate, noCount, pollId, startDate, title, yesCount);
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
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(description, other.description)
				&& Objects.equals(endDate, other.endDate) && noCount == other.noCount
				&& Objects.equals(pollId, other.pollId) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(title, other.title) && yesCount == other.yesCount;
	}

	@Override
	public String toString() {
		return "Poll [pollId=" + pollId + ", title=" + title + ", description=" + description + ", creationDate="
				+ creationDate + ", startDate=" + startDate + ", endDate=" + endDate + ", yesCount=" + yesCount
				+ ", noCount=" + noCount + "]";
	}

}
