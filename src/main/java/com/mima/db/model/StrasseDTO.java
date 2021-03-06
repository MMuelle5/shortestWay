package com.mima.db.model;

import java.io.Serializable;

/**
 * Der DJ-Algo arbeitet mit diesem DTO
 * (Anzeigeangaben sind nicht notwendig)
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public class StrasseDTO implements Serializable {

	private Long startPunktId;
	private Long endPunktId;
	private double distanz;
	private int speed;
	private boolean isMaut;
	
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isMaut() {
		return isMaut;
	}
	public void setMaut(boolean isMaut) {
		this.isMaut = isMaut;
	}	
	
	public void initGegenrichtung(StrasseDTO dto) {
		this.startPunktId = dto.getEndPunktId();
		this.endPunktId = dto.getStartPunktId();
		this.speed = dto.getSpeed();
		this.isMaut = dto.isMaut();
		this.distanz = dto.getDistanz();
	}
	
}
