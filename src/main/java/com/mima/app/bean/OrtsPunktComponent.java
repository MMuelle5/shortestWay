package com.mima.app.bean;

public class OrtsPunktComponent {

	private String name;
	private int xStart;
	private int yStart;
	
	public OrtsPunktComponent(int xStart, int yStart, String name) {
		super();
		this.xStart = xStart;
		this.yStart = yStart;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
