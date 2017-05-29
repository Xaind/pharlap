package com.parker.pharlap.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parker.pharlap.domain.RaceDay;
import com.parker.pharlap.service.DataMiningService;

@RestController
public class MainController {

	private final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private DataMiningService dataMiningService;
	
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	
	@RequestMapping("/getUpcomingRaceDays")
	public List<RaceDay> getRaceDays() {
		return dataMiningService.getUpcomingRaceDays();
	}
	
	@RequestMapping("/raceDay")
	public List<RaceDay> getRaceDays(@RequestParam("date") Date date) {
	    return dataMiningService.getUpcomingRaceDays();
	}
}
