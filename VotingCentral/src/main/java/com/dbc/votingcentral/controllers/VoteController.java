package com.dbc.votingcentral.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.votingcentral.dto.Response;
import com.dbc.votingcentral.dto.VoteDTO;
import com.dbc.votingcentral.entities.Vote;
import com.dbc.votingcentral.services.Messages;
import com.dbc.votingcentral.services.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteController {
	
//	@Autowired
//	private DocumentValidator documentValidator;
	@Autowired
	private Messages messages;
	@Autowired
	private VoteService voteService;
	
	@PostMapping("/castVote/{pollId}")
	public ResponseEntity<Response<Vote>> castVote(@PathVariable String pollId, @RequestBody VoteDTO voteDto, BindingResult result) {
		
		Response<Vote> resp = new Response<Vote>();
		Vote vote;
		try {
			vote = voteService.save(voteDto, pollId);
		}catch(Exception e) {
			resp.addErrors(messages.getBadRequestCreatePollMesage());
			return ResponseEntity.badRequest().body(resp);
		}
		
		resp.setData(vote);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/{voteId}")
	public ResponseEntity<Response<Vote>> getVote(@PathVariable String voteId){
		Response<Vote> resp = new Response<Vote>();
		Vote vote;
		try {
			vote = voteService.getVote(voteId);
		}catch(NoSuchElementException nsee) {
			return ResponseEntity.notFound().build();
		}
		
		resp.setData(vote);
		return ResponseEntity.ok(resp);
	}
}
