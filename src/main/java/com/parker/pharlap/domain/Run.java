package com.parker.pharlap.domain;

/**
 * Specific details of a horse for a specific race.
 */
public class Run extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	private int distance;
	private double finishTime;
	private double margin;
	private double weight;
	private TrackRating trackRating;
	private int barrier;
	private int totalRunners;
	private double jockyRating;
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public double getFinishTime() {
		return finishTime;
	}
	
	public void setFinishTime(double finishTime) {
		this.finishTime = finishTime;
	}
	
	public double getMargin() {
		return margin;
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public TrackRating getTrackRating() {
		return trackRating;
	}
	
	public void setTrackRating(TrackRating trackRating) {
		this.trackRating = trackRating;
	}
	
	public int getBarrier() {
		return barrier;
	}
	
	public void setBarrier(int barrier) {
		this.barrier = barrier;
	}
	
	public int getTotalRunners() {
		return totalRunners;
	}
	
	public void setTotalRunners(int totalRunners) {
		this.totalRunners = totalRunners;
	}
	
	public double getJockyRating() {
		return jockyRating;
	}
	
	public void setJockyRating(double jockyRating) {
		this.jockyRating = jockyRating;
	}
}
