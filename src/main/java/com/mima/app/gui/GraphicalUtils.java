package com.mima.app.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.mima.db.model.OrtDTO;

/**
 * Hilfsklasse zum zeichnen der Punkte/Wege
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public class GraphicalUtils {

	public static final int RAD = 35;
	public static final String NEWPOINT = "Neuen Wegpunkt";
	public static final String NEWSTREET = "Neue Verbindung";
	public static final String DELETE = "Wegpunkt inkl. Verbindungen löschen";
	
	public static void drawLine(Graphics g, int xAxisStart, int yAxisStart,
			int xAxisEnd, int yAxisEnd, int speed, boolean isShortestWay) {

		if(isShortestWay) {
			g.setColor(Color.CYAN);
		}
		else {
			g.setColor(Color.BLACK);
		}
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(GraphicalUtils.getSpeedWidth(speed)));
		g2.drawLine(xAxisStart + RAD, yAxisStart + RAD, xAxisEnd + RAD, yAxisEnd	+ RAD);

	}

	public static void drawOval(Graphics g, int xAxis, int yAxis, String name, int shortestWay) {
		if(shortestWay == OrtDTO.SHORTESTWAY) {
			g.setColor(Color.CYAN);
		}
		else if(shortestWay == OrtDTO.STARTENDPOINT) {
			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(Color.LIGHT_GRAY);
		}
		// g.drawOval(xAxis, yAxis, diameter, diameter);
		g.fillOval(xAxis, yAxis, (RAD*2), (RAD*2));

		g.setColor(Color.black);
		drawLabel(g, name, xAxis, yAxis);
	}

	public static void drawLabel(Graphics g, String text, int xAxis, int yAxis) {

		g.drawString(text, xAxis + (RAD*2) / 3, yAxis + (RAD*2) / 2 + 5);
	}
	
	public static int getSpeedWidth(int speed) {
		if(speed == 50) {
			return 1;
		}
		else if(speed == 80) {
			return 2;
		}
		else if(speed == 120){
			return 3;
		}
		else {
			return 0;
		}
	}
}
