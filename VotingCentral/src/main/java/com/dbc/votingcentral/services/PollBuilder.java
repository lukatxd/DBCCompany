package com.dbc.votingcentral.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;

import com.dbc.votingcentral.entities.Poll;

public class PollBuilder {

	private Poll poll;

	PollBuilder() {
		poll = new Poll();
	}

	private Calendar startTime;
	private int duration;
	private int timeUnit;

	public PollBuilder withTitle(String title) {
		poll.setTitle(title);
		return this;
	}

	public PollBuilder withDescription(String description) {
		poll.setDescription(description);
		return this;
	}

	public PollBuilder withStartDate(String startDate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		if (null != startDate) {
			cal.setTime(DateUtils.parseDateString(startDate));
			this.startTime = cal;
			poll.setStartDate(new Timestamp(cal.getTimeInMillis()));
		}
		return this;
	}

	public PollBuilder withStartDate(Timestamp startDate) {
		poll.setStartDate(startDate);
		return this;
	}

	public PollBuilder withDuration(String duration, String timeUnit) throws ParseException {

		resolveDuration(duration);
		resolveTimeUnit(timeUnit);
		return this;
	}

	private void resolveDuration(String duration) {
		if (null == duration) {
			this.duration = 1;
		}else {
			this.duration = Integer.parseInt(duration);
		}
	}

	private void resolveTimeUnit(String timeUnit) throws ParseException {
		if (null == timeUnit) {
			this.timeUnit = Calendar.MINUTE;
		} else {
			switch (timeUnit) {
			case "minutes":
				this.timeUnit = Calendar.MINUTE;
				break;
			case "hours":
				this.timeUnit = Calendar.HOUR;
				break;
			case "days":
				this.timeUnit = Calendar.DAY_OF_YEAR;
				break;
			default:
				throw new ParseException(timeUnit, 0);
			}
		}
	}

	public Poll build() {
		if (null == this.startTime) {
			this.startTime = Calendar.getInstance();
			this.poll.setStartDate(new Timestamp(this.startTime.getTimeInMillis()));
		}
		this.startTime.add(timeUnit, duration);
		final Timestamp endDate = new Timestamp(this.startTime.getTimeInMillis());
		this.poll.setEndDate(endDate);

		return poll;
	}
}
