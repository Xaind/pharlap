package com.parker.pharlap.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parker.pharlap.domain.RaceDay;

@RestController
public class MainController {

	private final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	
	@RequestMapping("/execute")
	public void execute(@RequestBody RaceDay raceDay) {
		LOGGER.info("Date is: " + raceDay.getDate());
	}
}
