package com.sentech.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A race horse.
 */
public class Horse extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private List<RaceDetail> raceDetails;

	public Horse(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RaceDetail> getRaceDetails() {
		return raceDetails;
	}

	public void setRaceDetails(List<RaceDetail> raceDetails) {
		this.raceDetails = raceDetails;
	}
	
	public void addRaceDetail(RaceDetail raceDetail) {
		if (this.raceDetails == null) {
			this.raceDetails = new ArrayList<>();
		}
		this.raceDetails.add(raceDetail);
	}
}
