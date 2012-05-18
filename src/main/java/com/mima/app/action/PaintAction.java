package com.mima.app.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import com.mima.app.bean.OrtsPunktComponent;
import com.mima.app.bean.StrasseComponent;
import com.mima.app.gui.GraphicalComponents;
import com.mima.app.gui.GraphicalUtils;
import com.mima.app.gui.PaintBean;

public class PaintAction implements ActionListener{

	private JPanel p;
	private List<OrtsPunktComponent> orte;
	private List<StrasseComponent> strassen;
	private PaintBean pb;
	

	public PaintAction(GraphicalComponents graphicalComponents, List<OrtsPunktComponent> list, List<StrasseComponent> str, PaintBean pb) {
		this.p = graphicalComponents;
		this.orte = list;
		this.strassen = str;
		this.pb = pb;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		if(GraphicalUtils.NEWPOINT.equals(e.getActionCommand())) {
			System.out.println(pb.getxAxis());
			System.out.println(pb.getyAxis());
//			String name = JOptionPane.showInputDialog("Orstzbezeichnug eingeben:", "neuer Ort");
//			if(StringUtils.isNotEmpty(name)) {
//				orte.add(new OrtsPunktComponent(pb.getxAxis(), pb.getyAxis(), name));
//			}
			orte.add(new OrtsPunktComponent(pb.getxAxis(), pb.getyAxis(), "Wusch"));
		}
		else {
			
		}

		try {
			Thread.sleep(150);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		p.repaint();
	}
}
