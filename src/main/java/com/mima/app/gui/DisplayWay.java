package com.mima.app.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mima.app.action.FindWayAction;
import com.mima.app.bean.GuiRelevantBean;

public class DisplayWay {

	private JFrame frame;
	private GuiRelevantBean bean = new GuiRelevantBean();
	private FindWayAction action;
	
	public DisplayWay() {
		super();
		frame = new JFrame("Routensucher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bean.setNavi(new JPanel(new GridBagLayout()));
		action = new FindWayAction(bean, frame);
	}

	public void displayContentPanel() {
		
		DisplayEast.getNavigation(bean, action);
		
		bean.setPanel(new JPanel(new BorderLayout()));

		GraphicalComponents gc = new GraphicalComponents(frame);
		
		bean.getPanel().add(gc, BorderLayout.CENTER);
		
		bean.getPanel().add(bean.getNavi(), BorderLayout.EAST);
		

		
		frame.add(bean.getPanel());
		frame.setPreferredSize(new Dimension(800,800));
		frame.pack();
		frame.setVisible(true);
	}
	
}
