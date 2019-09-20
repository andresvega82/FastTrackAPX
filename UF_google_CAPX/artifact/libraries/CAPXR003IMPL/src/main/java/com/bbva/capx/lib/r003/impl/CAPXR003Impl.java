package com.bbva.capx.lib.r003.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bbva.capx.lib.r003.CAPXR003;

public class CAPXR003Impl extends CAPXR003Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CAPXR003.class);

	
	
	@Override
	public ResponseEntity<String> execute(String origin, String destination) {
		
		RestTemplate response = new RestTemplate();
		ResponseEntity<String> quote = response.getForEntity("https://maps.googleapis.com/maps/api/directions/json?origin=" + origin
				+ "&destination="+destination+",SA&key=AIzaSyByPeqwGB3sb1BXGhEkzfzmnOodqugTM6Q", String.class);
		return quote;
	}
}
