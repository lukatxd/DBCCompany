package com.dbc.votingcentral.services;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.votingcentral.dto.VoteDTO;
import com.dbc.votingcentral.entities.Poll;
import com.dbc.votingcentral.entities.Vote;
import com.dbc.votingcentral.repositories.VoteRepository;
import com.dbc.votingcentral.services.documentValidator.AbilityToVote;
import com.dbc.votingcentral.services.documentValidator.VoterDocumentStatus;

@Service
public class VoteService {
	
	@Autowired
	private PollService pollService; 
	@Autowired
	private VoteRepository voteRepository;
	
	public Vote save(VoteDTO voteDto, VoterDocumentStatus voterStatus) {
		Vote vote = null;
		if(AbilityToVote.ABLE_TO_VOTE.equals(voterStatus.getAbilityToVote())) {
			Poll poll =pollService.getPoll(voteDto.getPollId());
			
			Vote existingVote = voteRepository.findByPollIdAndUserDocument(poll, voteDto.getDocument());
			if(existingVote !=null) {
				return vote;
			}
					
			Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
			if(poll.getEndDate().after(now)) {
				vote = new Vote(poll, voteDto.getDocument(), voteDto.getChoice());
				voteRepository.save(vote);
			}	
		}
		return vote;
	}

	public Vote getVote(String voteId) {
		return voteRepository.getById(voteId);
	}
}
