package com.mima.app.gui;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mima.app.action.FindWayAction;
import com.mima.app.bean.GuiRelevantBean;

/**
 * Rechte Seite vom GUI
 * Auswahl des Start/Zielpunktes, Optionen und Start der Routensuche
 *
 * @author i10b@zhaw: M. MŸller / M. Ott
 *
 */
public class DisplayEast {

	private static JButton go = new JButton("Go");
	
	public static JPanel getNavigation(GuiRelevantBean bean, FindWayAction action) {
//		JPanel bean.getNavi() = new JPanel(new GridBagLayout());
		bean.getNavi().setBorder(new EmptyBorder(3, 3, 3, 3));
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 0.5;
		gc.gridx = 0;
		gc.gridy = 0;

		bean.getNavi().add(bean.getStartPunkt(), gc);
		gc.weightx = 0.5;
		gc.gridx = 1;
		gc.gridy = 0;
		bean.getNavi().add(bean.getStart(), gc);

		gc.weightx = 0.5;
		gc.gridx = 0;
		gc.gridy = 1;
		bean.getNavi().add(bean.getEndPunkt(), gc);
		gc.weightx = 0.5;
		gc.gridx = 1;
		gc.gridy = 1;
		bean.getNavi().add(bean.getEnde(), gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0.5;
		bean.getNavi().add(bean.getMaut(), gc);
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0.5;
		bean.getNavi().add(new JLabel("Mit gebühren"), gc);

		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 0.5;
		bean.getNavi().add(new JLabel("Option: "), gc);
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 0.5;
		bean.getNavi().add(bean.getOption(), gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 0;
		go.addActionListener(action);
		bean.getNavi().add(go, gc);
		
		return bean.getNavi();

	}
}
