package com.dbc.votingcentral.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dbc.votingcentral.dto.PollDTO;
import com.dbc.votingcentral.dto.Response;
import com.dbc.votingcentral.entities.Poll;
import com.dbc.votingcentral.services.Messages;
import com.dbc.votingcentral.services.PollService;

@Controller
@RequestMapping("/poll")
public class PollController {

	@Autowired
	private PollService pollService;
	@Autowired
	private Messages messages;
	
	@PostMapping("/createPoll")
	public ResponseEntity<Response<Poll>> createPoll(@Validated @RequestBody PollDTO pollDto, BindingResult result) {
		
		Response<Poll> resp = new Response<Poll>();
		Poll poll;
		try {
			poll = pollService.save(pollDto);
		}catch(Exception e) {
			resp.addErrors(messages.getMessage("badRequest.createPoll.message"));
			return ResponseEntity.badRequest().body(resp);
		}
		
		resp.setData(poll);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/{pollId}")
	public ResponseEntity<Response<Poll>> checkPoll(@PathVariable String pollId) {
		Response<Poll> resp = new Response<Poll>();
		Poll poll;
		try {
			poll = pollService.getPoll(pollId);
		}catch(NoSuchElementException nsee) {
			return ResponseEntity.notFound().build();
		}
		resp.setData(poll);
		return ResponseEntity.ok(resp);
	}
	
}
