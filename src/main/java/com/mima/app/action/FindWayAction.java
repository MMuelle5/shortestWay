package com.mima.app.action;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mima.app.Dijkstra;
import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.GuiRelevantBean;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.exception.BoException;
import com.mima.db.mock.StrassenMock;

public class FindWayAction implements ActionListener {

	private GuiRelevantBean bean;
	private JFrame frame;
	
	public FindWayAction(GuiRelevantBean bean, JFrame frame) {
		super();
		this.bean = bean;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BerechnungsOptionen calc = new BerechnungsOptionen();
		calc.setMautAllowed(bean.getMaut().isSelected());
		calc.setOption(String.valueOf(bean.getOption().getSelectedItem()));
		
		StrasseDao dao = new StrassenMock();
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(dao), calc);
		JPanel center = new JPanel(new GridBagLayout());
		center.setBorder(new EmptyBorder(3, 3, 3, 3));
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
//		gc.weightx = 0.5;
		gc.gridx = 0;
		gc.gridy = 0;
		try {
			OrtsPunktBean opb = dj.run(Long.valueOf(bean.getStart().getText()), Long.valueOf(bean.getEnde().getText()));
//			String[] weg = opb.getHistory().split(", ");
//			for(int i = 0; i < weg.length; i++) {
//				gc.gridy=i;
//				center.add(new JLabel(weg[i]), gc);
//			}
			int gridY = 0;
			String ausgabe = null;
			for(int i = opb.getWay().size()-1; i >=0; i--) {
				gc.gridy=gridY;
				if(opb.getWay().get(i).getPrevPunkt() != null) {
					ausgabe = "Strecke von "+opb.getWay().get(i).getPrevPunkt().getPunkteBeschreibung()+" in Richtung "+opb.getWay().get(i).getPunkteBeschreibung()
							+" "+(opb.getWay().get(i).getDistanz()-opb.getWay().get(i).getPrevPunkt().getDistanz()+ " km folgen");
				}
				
				center.add(new JLabel(ausgabe), gc);
				gridY++;
			}
			gc.gridy++;
			center.add(new JLabel("Sie haben "+opb.getPunkteBeschreibung()+" nach "+opb.getDistanz()+"km erreicht."), gc);
			frame.add(bean.getNavi(), BorderLayout.EAST);
			frame.add(center, BorderLayout.CENTER);
			frame.pack();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (BoException e) {
			e.printStackTrace();
		}
	}

}
