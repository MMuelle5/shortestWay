package com.mima.app.action;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mima.app.Dijkstra;
import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.GuiRelevantBean;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.app.gui.GraphicalComponents;
import com.mima.db.bo.impl.PointBoImpl;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.PointDao;
import com.mima.db.dao.StrasseDao;
import com.mima.db.daofactory.DAOFactory;
import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseComponentDTO;

public class FindWayAction implements ActionListener {

	private GuiRelevantBean bean;
	private JFrame frame;
	private List<StrasseComponentDTO> strassen;
	private List<OrtDTO> orte;
	private DAOFactory factory;
	private GraphicalComponents gc;
	
	public FindWayAction(GuiRelevantBean bean, JFrame frame, List<StrasseComponentDTO> strassen, List<OrtDTO> orte, GraphicalComponents gc) {
		super();
		this.bean = bean;
		this.frame = frame;
		this.orte = orte;
		this.strassen = strassen;
		this.factory = DAOFactory.getInstance();
		this.gc = gc;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BerechnungsOptionen calc = new BerechnungsOptionen();
		calc.setMautAllowed(bean.getMaut().isSelected());
		calc.setOption(String.valueOf(bean.getOption().getSelectedItem()));

		StrasseDao dao = factory.getStrasseDao();
		PointDao pdao = factory.getPointDao();
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(dao), new PointBoImpl(pdao), calc);
		
		try {
			OrtsPunktBean opb = dj.run(Long.valueOf(bean.getStart().getText()), Long.valueOf(bean.getEnde().getText()));
			Map<Integer, Integer> ortsMap = new HashMap<Integer, Integer>();
			Map<Integer, Integer> streetMap = new HashMap<Integer, Integer>();
			
			displayWayDescription(opb, ortsMap);
			
			for(OrtDTO ort : orte) {
				Integer strHash = ortsMap.get(ort.getPointId().intValue());
				if(ort.getPointId() == Long.valueOf(bean.getStart().getText()) || ort.getPointId() == Long.valueOf(bean.getEnde().getText())) {
					ort.setShortestWay(OrtDTO.STARTENDPOINT);
				}
				else if(strHash != null) {
					ort.setShortestWay(OrtDTO.SHORTESTWAY);
					streetMap.put(strHash, strHash);
					System.out.println(strHash);
				}
				else {
					ort.setShortestWay(OrtDTO.DEFAULT);
				}
			}
			
			for(StrasseComponentDTO sc : strassen) {
				System.out.println(sc.hashCode());
				if(streetMap.get(sc.hashCode()) != null) {
					sc.setShortestWay(true);
				}
				else {
					sc.setShortestWay(false);
				}
			}
			
			
			gc.repaint();
			
			frame.setVisible(false);
			frame.pack();
			frame.setVisible(true);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (BoException e) {
			e.printStackTrace();
		}
	}
	
	private void displayWayDescription(OrtsPunktBean opb, Map<Integer, Integer> ortsMap) {
		
		JFrame f = new JFrame("Streckenbeschreib von "+ bean.getStart().getText() +" nach "+bean.getEnde().getText());
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel center = new JPanel(new GridBagLayout());
		center.setBorder(new EmptyBorder(3, 3, 3, 3));
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		
		String ausgabe = null;
		double steigungA = 0;
		double steigungB = 0;
		double km;
		for(int i = opb.getWay().size()-1; i >=0; i--) {
			steigungB = steigungA;
			
			Integer pktHash = opb.getWay().get(i).getPunkteId().intValue();


			if(opb.getWay().get(i).getPrevPunkt() != null) {
				pktHash = pktHash+opb.getWay().get(i).getPunkteId().intValue();
				km = opb.getWay().get(i).getDistanz()-opb.getWay().get(i).getPrevPunkt().getDistanz();
				
				if(i == opb.getWay().size()-2) {
					ausgabe = "Strecke von "+opb.getWay().get(i).getPrevPunkt().getPunkteBeschreibung()+" in Richtung "+opb.getWay().get(i).getPunkteBeschreibung()
							+" "+km+ " km folgen";
				}
				else{
					double x = opb.getWay().get(i).getPointX()-opb.getWay().get(i).getPrevPunkt().getPointX();
					double y = opb.getWay().get(i).getPointY()-opb.getWay().get(i).getPrevPunkt().getPointY();
					steigungA = y/x;
					double diff = steigungA - steigungB; //FIXME etwas stimmt hier nicht
					System.out.println(diff);
					if(diff < 4 && diff > -4) {
						ausgabe = "Dem Streckenverlauf "+ km +" km in Richtung "+opb.getWay().get(i).getPunkteBeschreibung() +" folgen";
					}
					else if(diff >= 0.1) {
						ausgabe = "Links in Richtung "+ opb.getWay().get(i).getPunkteBeschreibung()+" abbiegen und  "+ km +" km dem Streckenverlauf folgen";
					}
					else {
						ausgabe = "Rechts in Richtung "+ opb.getWay().get(i).getPunkteBeschreibung()+" abbiegen und  "+ km +" km dem Streckenverlauf folgen";
					}
				}
				
				ortsMap.put(opb.getWay().get(i).getPunkteId().intValue(), pktHash);
			}
			
			center.add(new JLabel(ausgabe), gc);
			gc.gridy++;
			
		}
		gc.gridy++;
		f.add(center);
		f.pack();
		f.setVisible(true);
		center.add(new JLabel("Sie haben "+opb.getPunkteBeschreibung()+" nach "+opb.getDistanz()+"km erreicht."), gc);
	}

}
