package com.parker.pharlap.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a race horse and its next and previous runs.
 */
public class Horse extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private Run nextRun;
	private List<Run> previousRuns;

	public Horse(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Run getNextRun() {
		return nextRun;
	}

	public void setNextRun(Run nextRun) {
		this.nextRun = nextRun;
	}

	public List<Run> getPreviousRuns() {
		if (previousRuns == null) {
			previousRuns = new ArrayList<>();
		}
		return previousRuns;
	}

	public void setPreviousRuns(List<Run> previousRuns) {
		this.previousRuns = previousRuns;
	}
	
	public void addPreviousRun(Run run) {
		getPreviousRuns().add(run);
	}
}
