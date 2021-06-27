package com.dbc.votingcentral.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static Date parseDateString(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/aaaa");
		return sdf.parse(date);
	}
	
}
