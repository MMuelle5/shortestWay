package com.mima.app.gui;

/**
 * Bean, das den Mousepress/release Punkt speichert
 * und der PaintAction uebergibt
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public class PaintBean {

	private int xAxis = 0;
	private int yAxis = 0;
	private int xAxisEnd = 0;
	private int yAxisEnd = 0;
	private Long pointId;
	
	
	public Long getPointId() {
		return pointId;
	}
	public void setPointId(Long pointId) {
		this.pointId = pointId;
	}
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public int getxAxisEnd() {
		return xAxisEnd;
	}
	public void setxAxisEnd(int xAxisEnd) {
		this.xAxisEnd = xAxisEnd;
	}
	public int getyAxisEnd() {
		return yAxisEnd;
	}
	public void setyAxisEnd(int yAxisEnd) {
		this.yAxisEnd = yAxisEnd;
	}
	
}
