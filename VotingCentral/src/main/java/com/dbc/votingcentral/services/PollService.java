package com.dbc.votingcentral.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.votingcentral.dto.PollDTO;
import com.dbc.votingcentral.entities.Poll;
import com.dbc.votingcentral.entities.Vote;
import com.dbc.votingcentral.repositories.PollRepository;
import com.dbc.votingcentral.repositories.VoteRepository;

@Service
public class PollService {
	
	@Autowired
	private PollRepository pollRepository;
	@Autowired
	private VoteRepository voteRepository;

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
		Poll poll = pollRepository.findById(pollId).get();
		getPollVoteCount(poll);
		return poll;
	}

	private void getPollVoteCount(Poll poll) {
		//Definitivamente não estou satisfeito com esta chamada abaixo,
		//Spring não estava aceitando iniciar com minhas named queries pra filtrar no banco
		List<Vote> votes = voteRepository.findByPollId(poll);
		int yesCount=0;
		int noCount=0;
		//Também não foi possivel fazer com stream pra filtrar a lista
		for(Vote vote : votes) {
			if(vote.isChoice()) {
				yesCount++;
			}else {
				noCount++;
			}
		}
		poll.setYesCount(yesCount);
		poll.setNoCount(noCount);
	}
}
