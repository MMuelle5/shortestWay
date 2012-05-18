package com.mima.app.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Runt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GraphicalComponents gc = new GraphicalComponents(frame);
				
		frame.add(gc);
		frame.setPreferredSize(new Dimension(500,500));
		frame.pack();
		frame.setVisible(true);
	}

}
