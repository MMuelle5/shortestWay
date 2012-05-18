package com.mima.app.gui;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicalUtils {

	public static final int RAD = 35;
	public static final String NEWPOINT = "Neuen Wegpunkt";
	public static final String NEWSTREET = "Neue Verbindung";
	public static final String DELETE = "Wegpunkt inkl. Verbindungen löschen";
	
	public static void drawLine(Graphics g, int xAxisStart, int yAxisStart,
			int xAxisEnd, int yAxisEnd) {

		g.drawLine(xAxisStart + RAD, yAxisStart + RAD, xAxisEnd + RAD, yAxisEnd	+ RAD);

	}

	public static void drawOval(Graphics g, int xAxis, int yAxis, String name) {
		g.setColor(Color.LIGHT_GRAY);
		// g.drawOval(xAxis, yAxis, diameter, diameter);
		g.fillOval(xAxis, yAxis, (RAD*2), (RAD*2));

		g.setColor(Color.black);
		drawLabel(g, name, xAxis, yAxis);
	}

	public static void drawLabel(Graphics g, String text, int xAxis, int yAxis) {

		g.drawString(text, xAxis + (RAD*2) / 3, yAxis + (RAD*2) / 2 + 5);
	}
}
