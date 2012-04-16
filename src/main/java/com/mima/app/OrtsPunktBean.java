package com.mima.app;

import java.util.List;

public class OrtsPunktBean {

	private Long punkteId;
	private String punkteBeschreibung;
	private double distanz;
	private boolean isKontrolliert;
	private List<OrtsPunktBean> punkteHistory;
	
	public Long getPunkteId() {
		return punkteId;
	}
	public void setPunkteId(Long punkteId) {
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
	public boolean isKontrolliert() {
		return isKontrolliert;
	}
	public void setKontrolliert(boolean isKontrolliert) {
		this.isKontrolliert = isKontrolliert;
	}
	
}
