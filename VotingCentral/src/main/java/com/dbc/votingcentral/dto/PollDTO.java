package com.dbc.votingcentral.dto;

import org.springframework.lang.NonNull;

public class PollDTO {
	
	String title;
	String description;
	String startDate;
	@NonNull
	String duration;
	@NonNull
	String timeUnit;
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getDuration() {
		return duration;
	}
	public String getTimeUnit() {
		return timeUnit;
	}

}
