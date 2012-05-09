package com.mima.app.bean;


public class OrtsPunktBean{

	private Long punkteId;
	private String punkteBeschreibung;
	private double streckenInklGewichtung;
	private double distanz;
	private boolean isKontrolliert;
	private OrtsPunktBean prevPunkt;
	
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
	public double getStreckenInklGewichtung() {
		return streckenInklGewichtung;
	}
	public void setStreckenInklGewichtung(double distanz) {
		this.streckenInklGewichtung = distanz;
	}
	public OrtsPunktBean getPrevPunkt() {
		return prevPunkt;
	}
	public void setPrevPunkt(OrtsPunktBean prevPunkt) {
		this.prevPunkt = prevPunkt;
	}
	public boolean isKontrolliert() {
		return isKontrolliert;
	}
	public void setKontrolliert(boolean isKontrolliert) {
		this.isKontrolliert = isKontrolliert;
	}
	public double getDistanz() {
		return distanz;
	}
	public void setDistanz(double distanz) {
		this.distanz = distanz;
	}
	public String getHistory() {
		String punkte = this.getPunkteBeschreibung();
		if(prevPunkt != null) {
			punkte = this.getPrevPunkt().getHistory()+", "+punkte;
		}
		
		return punkte;
	}
}
