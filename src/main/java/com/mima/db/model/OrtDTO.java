package com.mima.db.model;

public class OrtDTO {

	private Long pointId;
	private int pointX;
	private int pointY;
	private String description;
	
	public OrtDTO() {
		super();
	}
	public OrtDTO(int pointX, int pointY, String description) {
		super();
		this.pointX = pointX;
		this.pointY = pointY;
		this.description = description;
	}
	public Long getPointId() {
		return pointId;
	}
	public void setPointId(Long pointId) {
		this.pointId = pointId;
	}
	public int getPointX() {
		return pointX;
	}
	public void setPointX(int pointX) {
		this.pointX = pointX;
	}
	public int getPointY() {
		return pointY;
	}
	public void setPointY(int pointY) {
		this.pointY = pointY;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
