package com.dbc.votingcentral.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbc.votingcentral.entities.Poll;
import com.dbc.votingcentral.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, String>{

	public List<Vote> findByPollId(Poll poll);
	
	public Vote findByPollIdAndUserDocument(Poll poll, String document);
}
