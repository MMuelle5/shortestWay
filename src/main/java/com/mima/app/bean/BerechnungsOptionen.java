package com.mima.app.bean;

import com.mima.db.model.Strasse;

/**
 * Verschieden berechnungs-Attribute koennen angegeben werden:
 * 1. Mautpflicht ja/nein
 * 2. Optionen:
 * 		- 0 = kuerzester Weg
 * 		- 1 = schnellster Weg
 * @author MARIUS
 *
 */
public class BerechnungsOptionen {

	public static final String SHORTESTWAY="Kürzester Weg";
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
	
	public double calcDistanzInklGew(double aktDistInklGew, Strasse add) {
		
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
