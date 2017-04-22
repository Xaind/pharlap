package com.parker.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.parker.domain.Track;

/**
 * Service for locating horse and race data.
 */
@Service
public class DataMiningService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataMiningService.class);

	@Value("${url.form}")
	private String formUrl;
	
	@Value("${url.horse}")
	private String horseUrl;
	
	@Value("${url.race}")
	private String raceUrl;
	
	@Value("${url.jockey}")
	private String jockeyUrl;
	
	public void getForm(Track track, String date, int raceNo) {
		String url = MessageFormat.format(formUrl, track.getCode(), date, raceNo);
		LOGGER.info(getPage(url));
	}
	
	public void getHorse(String name) {
		String url = MessageFormat.format(horseUrl, name);
		LOGGER.info(getPage(url));
	}
	
	protected String getPage(String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}

}
