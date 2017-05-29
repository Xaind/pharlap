package com.parker.pharlap.domain;

/**
 * Race tracks. 
 */
public enum Track {
	
	ASCOT("ascot"),
	WARWICK_FARM("w_fm"),
	DARWIN("darwin"),
	GOLD_COAST("gold_coast"),
	DOOMBEN("doom"),
	EAGLE_FARM("e_fm"),
	FLEMINGTON("flem"),
	RANDWICK("rand");
	
	private String code;
	
	private Track(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static Track findByName(String trackName) {
	    for (Track track : values()) {
	        if (track.name().equals(trackName)) {
	            return track;
	        }
	    }
	    return null;
	}
}
