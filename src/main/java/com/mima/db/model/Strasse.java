package com.mima.db.model;

import java.io.Serializable;

public class Strasse implements Serializable {

	private Long startPunktId;
	private Long endPunktId;
	private double distanz;
	
	public double getDistanz() {
		return distanz;
	}
	public void setDistanz(double distanz) {
		this.distanz = distanz;
	}
	public Long getStartPunktId() {
		return startPunktId;
	}
	public void setStartPunktId(Long startPunktId) {
		this.startPunktId = startPunktId;
	}
	public Long getEndPunktId() {
		return endPunktId;
	}
	public void setEndPunktId(Long endPunktId) {
		this.endPunktId = endPunktId;
	}	
	
}
