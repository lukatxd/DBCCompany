package com.dbc.votingcentral.controllers;

import java.util.NoSuchElementException;

import org.springframework.boot.configurationprocessor.json.JSONObject;
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
import com.dbc.votingcentral.services.VoteService;
import com.dbc.votingcentral.services.documentValidator.DocumentValidator;
import com.dbc.votingcentral.services.documentValidator.ValidAndAbleToVote;
import com.dbc.votingcentral.services.documentValidator.VoterDocumentStatus;

@RestController
@RequestMapping("/vote")
public class VoteController {
	
	@Autowired
	private DocumentValidator documentValidator;
	@Autowired
	private VoteService voteService;
	
	@PostMapping(produces = "application/json", path="/castVote")
	public ResponseEntity<JSONObject> castVote(@RequestBody VoteDTO voteDto, BindingResult result) {
		
		ResponseEntity<JSONObject> response;
		try {
			//VoterDocumentStatus voterStatus = documentValidator.validateDocument(voteDto.getDocument());
			VoterDocumentStatus voterStatus = new ValidAndAbleToVote();
			voteService.save(voteDto, voterStatus);
			response = voterStatus.getResponse();
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}		
		return response;
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
