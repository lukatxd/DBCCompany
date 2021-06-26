package com.dbc.votingcentral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbc.votingcentral.entities.Poll;

public interface PollRepository extends JpaRepository<Poll, String>{

}
