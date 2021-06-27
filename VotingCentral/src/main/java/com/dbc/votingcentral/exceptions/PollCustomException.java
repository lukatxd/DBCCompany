package com.dbc.votingcentral.exceptions;

public class PollCustomException extends Throwable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5742624735949887226L;
	public Exception ex;
	public String message;
	
	public PollCustomException(Exception ex, String message){
		this.ex = ex;
		this.message = message;
	}

}
