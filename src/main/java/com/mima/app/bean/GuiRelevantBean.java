package com.mima.app.bean;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Bean speichert GUI-Informationen
 * insbesondere Filter-/Suchkriterien
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public class GuiRelevantBean {

	private JPanel panel;
	private JPanel navi;
	private JLabel startPunkt = new JLabel("Startpunkt: ");
	private JTextField start = new JTextField();
	private JLabel endPunkt = new JLabel("Endpunkt: ");
	private JTextField ende = new JTextField();
	private JCheckBox maut = new JCheckBox();
	private JComboBox option = new JComboBox();

	
	public GuiRelevantBean() {
		super();
		option.addItem(BerechnungsOptionen.SHORTESTWAY);
		option.addItem(BerechnungsOptionen.FASTESTWAY);
	}

	public JPanel getNavi() {
		return navi;
	}

	public void setNavi(JPanel navi) {
		this.navi = navi;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getStartPunkt() {
		return startPunkt;
	}

	public void setStartPunkt(JLabel startPunkt) {
		this.startPunkt = startPunkt;
	}

	public JTextField getStart() {
		return start;
	}

	public void setStart(JTextField start) {
		this.start = start;
	}

	public JLabel getEndPunkt() {
		return endPunkt;
	}

	public void setEndPunkt(JLabel endPunkt) {
		this.endPunkt = endPunkt;
	}

	public JTextField getEnde() {
		return ende;
	}

	public void setEnde(JTextField ende) {
		this.ende = ende;
	}

	public JCheckBox getMaut() {
		return maut;
	}

	public void setMaut(JCheckBox maut) {
		this.maut = maut;
	}

	public JComboBox getOption() {
		return option;
	}

	public void setOption(JComboBox option) {
		this.option = option;
	}

}
