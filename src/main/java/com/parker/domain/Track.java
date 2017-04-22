package com.parker.domain;

/**
 * Race tracks. 
 */
public enum Track {
	
	DOOMBEN("doom"),
	RANDWICK("rand"),
	FLEMINGTON("flem");
	
	private String code;
	
	private Track(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
