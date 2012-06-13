package com.mima.app.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Relevant zur Berechnung des DJ-Algorithmus
 * Beinhaltet alle Wichtigen Infos dazu
 * u.A. den gesamten Pfad vom Startpunkt aus
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public class OrtsPunktBean{

	private Long punkteId;
	private String punkteBeschreibung;
	private double streckenInklGewichtung;
	private double distanz;
	private boolean isKontrolliert;
	private long pointX;
	private long pointY;
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
	public long getPointX() {
		return pointX;
	}
	public void setPointX(long pointX) {
		this.pointX = pointX;
	}
	public long getPointY() {
		return pointY;
	}
	public void setPointY(long pointY) {
		this.pointY = pointY;
	}
	/**
	 * Angelt sich rekursiv bis zum Startpunkt zurueck
	 * und fuellt dann alle Punkte nacheinander in eine Liste ab
	 * @return
	 */
	public List<OrtsPunktBean> getWay() {
		List<OrtsPunktBean> opb = new ArrayList<OrtsPunktBean>();
		opb.add(this);
		
		if(prevPunkt != null) {
			opb.addAll(this.getPrevPunkt().getWay());
		}
		
		return opb;
	}
	
	/**
	 * @return Den Gesamten Streckenverlauf wird als String zurueck gegeben
	 */
	public String getHistory() {
		String punkte = this.getPunkteBeschreibung();
		if(prevPunkt != null) {
			punkte = this.getPrevPunkt().getHistory()+", "+punkte;
		}
		
		return punkte;
	}
}
