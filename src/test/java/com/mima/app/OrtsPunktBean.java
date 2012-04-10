package com.mima.app;

import java.util.List;

public class OrtsPunktBean {

	private int punkteId;
	private String punkteBeschreibung;
	private double distanz;
	private List<OrtsPunktBean> punkteHistory;
	
	public int getPunkteId() {
		return punkteId;
	}
	public void setPunkteId(int punkteId) {
		this.punkteId = punkteId;
	}
	public String getPunkteBeschreibung() {
		return punkteBeschreibung;
	}
	public void setPunkteBeschreibung(String punkteBeschreibung) {
		this.punkteBeschreibung = punkteBeschreibung;
	}
	public double getDistanz() {
		return distanz;
	}
	public void setDistanz(double distanz) {
		this.distanz = distanz;
	}
	public List<OrtsPunktBean> getPunkteHistory() {
		return punkteHistory;
	}
	public void setPunkteHistory(List<OrtsPunktBean> punkteHistory) {
		this.punkteHistory = punkteHistory;
	}
	
	
}
