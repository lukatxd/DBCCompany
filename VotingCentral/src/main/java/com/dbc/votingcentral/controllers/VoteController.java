package com.dbc.votingcentral.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VoteController {
	{System.out.println("well at least it loaded");}

	@GetMapping("/oi")
	public String castVote(String pollId) {
		System.out.println(pollId);
		return "cu";
	}
	
}
