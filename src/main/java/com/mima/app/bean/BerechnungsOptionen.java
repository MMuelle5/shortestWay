package com.mima.app.bean;

import com.mima.db.model.Strasse;

public class BerechnungsOptionen {

	private boolean isMautAllowed;
	private int option;
	
	public boolean isMautAllowed() {
		return isMautAllowed;
	}
	public void setMautAllowed(boolean isMautAllowed) {
		this.isMautAllowed = isMautAllowed;
	}
	public int getOption() {
		return option;
	}
	public void setOption(int option) {
		this.option = option;
	}
	
	public double calcDistanzInklGew(double aktDistInklGew, Strasse add) {
		
		double newDistanz = 0;
		if(option == 0) {
			newDistanz = aktDistInklGew + add.getDistanz();
		}
		
		return newDistanz;
	}
}
