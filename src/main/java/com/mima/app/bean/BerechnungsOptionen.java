package com.mima.app.bean;

import com.mima.db.model.StrasseDTO;

/**
 * Verschieden berechnungs-Attribute koennen angegeben werden:
 * 1. Mautpflicht ja/nein
 * 2. Optionen:
 * 		- 0 = kuerzester Weg
 * 		- 1 = schnellster Weg
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public class BerechnungsOptionen {

	public static final String SHORTESTWAY="Kuerzester Weg";
	public static final String FASTESTWAY="Schnellster Weg";
	
	private boolean isMautAllowed;
	private String option;
	
	public boolean isMautAllowed() {
		return isMautAllowed;
	}
	public void setMautAllowed(boolean isMautAllowed) {
		this.isMautAllowed = isMautAllowed;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	/**
	 * Berechnet die "Distanz" anhand der gewaehlten Optionen
	 * Einstellung wird nur die Distanz oder die Distanz und Geschwindigkeit beruecksichtig
	 * @param aktDistInklGew
	 * @param add
	 * @return
	 */
	public double calcDistanzInklGew(double aktDistInklGew, StrasseDTO add) {
		
		double newDistanz = 0;
		if(BerechnungsOptionen.SHORTESTWAY.equals(option)) {
			newDistanz = aktDistInklGew + add.getDistanz();
		}
		else {
			newDistanz = aktDistInklGew + add.getDistanz()/add.getSpeed();
		}
		
		return newDistanz;
	}
}
