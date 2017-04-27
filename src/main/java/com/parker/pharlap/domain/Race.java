package com.parker.pharlap.domain;

import java.util.ArrayList;
import java.util.List;

public class Race extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private int distance;
	private TrackRating trackRating;
	private List<Horse> horses;
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public TrackRating getTrackRating() {
		return trackRating;
	}
	
	public void setTrackRating(TrackRating trackRating) {
		this.trackRating = trackRating;
	}
	
	public List<Horse> getHorses() {
		if (horses == null) {
			horses = new ArrayList<>();
		}
		return horses;
	}
	
	public void setHorses(List<Horse> horses) {
		this.horses = horses;
	}
	
	public void addHorse(Horse horse) {
		getHorses().add(horse);
	}

	public int getTotalRunners() {
		return getHorses().size();
	}
}
