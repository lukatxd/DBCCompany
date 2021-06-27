package com.dbc.votingcentral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.votingcentral.dto.VoteDTO;
import com.dbc.votingcentral.entities.Poll;
import com.dbc.votingcentral.entities.Vote;
import com.dbc.votingcentral.repositories.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	private PollService pollService; 
	@Autowired
	private VoteRepository voteRepository;
	
	public Vote save(VoteDTO voteDto, String pollId) {
		Poll poll =pollService.getPoll(pollId);
		Vote vote = new Vote(poll, voteDto.getDocument(), voteDto.getChoice());
		voteRepository.save(vote);
		return vote;
	}

	public Vote getVote(String voteId) {
		return voteRepository.getById(voteId);
	}
}
