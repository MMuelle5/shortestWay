package com.mima.app.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mima.app.action.FindWayAction;
import com.mima.app.bean.GuiRelevantBean;

public class DisplayWay {

	private JFrame frame;
	private GuiRelevantBean bean = new GuiRelevantBean();
	private FindWayAction action;
	private JButton go = new JButton("Go");
	
	public DisplayWay() {
		super();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		action = new FindWayAction(bean);
	}


	public void displayContentPanel() {

		bean.setPanel(new JPanel(new BorderLayout()));
		
		JPanel east = new JPanel(new GridBagLayout());
		east.setBorder(new EmptyBorder(3, 3, 3, 3));
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 0.5;
		gc.gridx = 0;
		gc.gridy = 0;
//		gc.gridheight = 1;
//		gc.gridwidth = 1;

		east.add(bean.getStartPunkt(), gc);
		gc.weightx = 0.5;
		gc.gridx = 1;
		gc.gridy = 0;
		east.add(bean.getStart(), gc);

		gc.weightx = 0.5;
		gc.gridx = 0;
		gc.gridy = 1;
		east.add(bean.getEndPunkt(), gc);
		gc.weightx = 0.5;
		gc.gridx = 1;
		gc.gridy = 1;
		east.add(bean.getEnde(), gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0.5;
		east.add(bean.getMaut(), gc);
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0.5;
		east.add(new JLabel("Mit gebühren"), gc);

		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 0.5;
		east.add(new JLabel("Option: "), gc);
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 0.5;
		east.add(bean.getOption(), gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 0;
		go.addActionListener(action);
		east.add(go, gc);
		
		bean.getPanel().add(east, BorderLayout.EAST);
		frame.add(bean.getPanel());
		frame.setPreferredSize(new Dimension(600,400));
		frame.pack();
		frame.setVisible(true);
	}
	
}
