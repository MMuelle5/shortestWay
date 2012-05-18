package com.mima.app.bean;

public class StrasseComponent {

	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	private double distanz;
	private int speed;
	private boolean isMaut;
	
	public StrasseComponent(int xStart, int yStart, int xEnd, int yEnd,
			double distanz) {
		super();
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.distanz = distanz;
	}
	public int getxStart() {
		return xStart;
	}
	public void setxStart(int xStart) {
		this.xStart = xStart;
	}
	public int getyStart() {
		return yStart;
	}
	public void setyStart(int yStart) {
		this.yStart = yStart;
	}
	public int getxEnd() {
		return xEnd;
	}
	public void setxEnd(int xEnd) {
		this.xEnd = xEnd;
	}
	public int getyEnd() {
		return yEnd;
	}
	public void setyEnd(int yEnd) {
		this.yEnd = yEnd;
	}
	public double getDistanz() {
		return distanz;
	}
	public void setDistanz(double distanz) {
		this.distanz = distanz;
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
}
