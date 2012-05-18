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
import com.mima.db.mock.StrassenMock01;

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
		
		StrasseDao dao = new StrassenMock01();
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(dao), calc);
		JPanel center = new JPanel(new GridBagLayout());
		center.setBorder(new EmptyBorder(3, 3, 3, 3));
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		try {
			OrtsPunktBean opb = dj.run(Long.valueOf(bean.getStart().getText()), Long.valueOf(bean.getEnde().getText()));
			
			String ausgabe = null;
			double steigungA = 0;
			double steigungB = 0;
			double km;
			for(int i = opb.getWay().size()-1; i >=0; i--) {
				steigungB = steigungA;

				if(opb.getWay().get(i).getPrevPunkt() != null) {
					km = opb.getWay().get(i).getDistanz()-opb.getWay().get(i).getPrevPunkt().getDistanz();
					
					if(i == opb.getWay().size()-2) {
						ausgabe = "Strecke von "+opb.getWay().get(i).getPrevPunkt().getPunkteBeschreibung()+" in Richtung "+opb.getWay().get(i).getPunkteBeschreibung()
								+" "+km+ " km folgen";
					}
					else{
						steigungA = (opb.getWay().get(i).getPointY()-opb.getWay().get(i).getPrevPunkt().getPointY())/(opb.getWay().get(i).getPointX()-opb.getWay().get(i).getPrevPunkt().getPointX());
						
						double diff = steigungA - steigungB;
						if(diff < 0.1 && diff > -0.1) {
							ausgabe = "Dem Streckenverlauf "+ km +" km in Richtung "+opb.getWay().get(i).getPunkteBeschreibung() +" folgen";
						}
						else if(diff >= 0.1) {
							ausgabe = "Links in Richtung "+ opb.getWay().get(i).getPunkteBeschreibung()+" abbiegen und  "+ km +" km dem Streckenverlauf folgen";
						}
						else {
							ausgabe = "Rechts abbiegen "+ opb.getWay().get(i).getPunkteBeschreibung()+" abbiegen und  "+ km +" km dem Streckenverlauf folgen";
						}
					}
				}
				
				center.add(new JLabel(ausgabe), gc);
				gc.gridy++;
				
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
