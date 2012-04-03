package com.mima.db.model;

import java.io.Serializable;

public class Strasse implements Serializable {

	private Long startPunktX;
	private Long startPunktY;
	private Long endPunktX;
	private Long endPunktY;
	private Long distanz;
	
	public Long getStartPunktX() {
		return startPunktX;
	}
	public void setStartPunktX(Long startPunktX) {
		this.startPunktX = startPunktX;
	}
	public Long getStartPunktY() {
		return startPunktY;
	}
	public void setStartPunktY(Long startPunktY) {
		this.startPunktY = startPunktY;
	}
	public Long getEndPunktX() {
		return endPunktX;
	}
	public void setEndPunktX(Long endPunktX) {
		this.endPunktX = endPunktX;
	}
	public Long getEndPunktY() {
		return endPunktY;
	}
	public void setEndPunktY(Long endPunktY) {
		this.endPunktY = endPunktY;
	}
	public Long getDistanz() {
		return distanz;
	}
	public void setDistanz(Long distanz) {
		this.distanz = distanz;
	}
	
	
}
