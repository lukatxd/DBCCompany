package com.dbc.votingcentral.services;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.votingcentral.dto.PollDTO;
import com.dbc.votingcentral.entities.Poll;
import com.dbc.votingcentral.repositories.PollRepository;

@Service
public class PollService {
	
	@Autowired
	private PollRepository pollRepository;

	public Poll save(PollDTO pollDto) throws ParseException {
		
		Poll poll = new PollBuilder()
				.withTitle(pollDto.getTitle())
				.withDescription(pollDto.getDescription())
				.withStartDate(pollDto.getStartDate())
				.withDuration(pollDto.getDuration(), pollDto.getTimeUnit())
				.build();
		
		return pollRepository.save(poll);
	}
	
	public Poll getPoll(String pollId) {
		return pollRepository.findById(pollId).get();
	}
}
