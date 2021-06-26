package com.dbc.votingcentral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbc.votingcentral.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, String>{

}
