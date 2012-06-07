package com.mima.db.model;


/**
 * beinhaltet alle nštigen Methoden um Strecken und deren Eigenschaften zu setzen/lesen
 *
 * @author i10b@zhaw: M. MŸller / M. Ott
 *
 */
public class StrasseComponentDTO {

	private int xStart;
	private int yStart;
	private Long startId;
	private int xEnd;
	private int yEnd;
	private Long endId;
	private double distanz;
	private int speed;
	private boolean isMaut;
	private boolean isShortestWay;
	
	public StrasseComponentDTO(int xStart, int yStart, int xEnd, int yEnd,
			double distanz) {
		super();
		this.xStart = xStart;
		this.yStart = yStart;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.distanz = distanz;
	}
	public StrasseComponentDTO() {
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
	public Long getStartId() {
		return startId;
	}
	public void setStartId(Long startId) {
		this.startId = startId;
	}
	public Long getEndId() {
		return endId;
	}
	public void setEndId(Long endId) {
		this.endId = endId;
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
	public boolean isShortestWay() {
		return isShortestWay;
	}
	public void setShortestWay(boolean isShortestWay) {
		this.isShortestWay = isShortestWay;
	}
	
	public void incSpeed() {
		if(speed == 50) {
			speed = 80;
		}
		else if(speed == 80) {
			speed = 120;
		}
		else if(speed == 120) {
			speed = 0;
		}
		else {
			speed =50;
		}
	}
	
	public int hashCode() {
		return (int) (startId+endId);
	}
	
}
