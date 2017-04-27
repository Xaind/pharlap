package com.parker.pharlap.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceDay extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private Date date;
	private Map<Track, List<Race>> tracks;
	
	public RaceDay(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Map<Track, List<Race>> getTracks() {
		if (tracks == null) {
			tracks = new HashMap<>();
		}
		return tracks;
	}
	
	public void setTracks(Map<Track, List<Race>> tracks) {
		this.tracks = tracks;
	}

	public List<Race> getRaces(Track track) {
		List<Race> races = getTracks().get(track);
		if (races == null) {
			races = new ArrayList<>();
			getTracks().put(track, races);
		}
		return races;
	}
}
