package com.mima.app.action;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mima.app.Dijkstra;
import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.GuiRelevantBean;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.app.gui.GraphicalComponents;
import com.mima.db.bo.PointBo;
import com.mima.db.bo.impl.PointBoImpl;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.PointDao;
import com.mima.db.dao.StrasseDao;
import com.mima.db.daofactory.DAOFactory;
import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseComponentDTO;

/**
 * 1. Liest die Berechnungsoptionen aus und uebergibt diese an Dijkstra.java
 * 2. Faerbt die betroffenen Punkte ein
 * 3. Listet die Wegpunkte auf
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
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
		
		PointBo pbo = new PointBoImpl(pdao);
		Long startId = null;
		try {
			startId = pbo.findPointIdByName(bean.getStart().getText());
		} catch (BoException e1) {
			JOptionPane.showMessageDialog(null, "Startpunkt wurde nicht gefunden", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Long endId = null;
		try {
			endId = pbo.findPointIdByName(bean.getEnde().getText());
		} catch (BoException e1) {
			JOptionPane.showMessageDialog(null, "Endpunkt wurde nicht gefunden", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Map<Integer, Integer> ortsMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> streetMap = new HashMap<Integer, Integer>();
		
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(dao), pbo, calc);
		
		try {
			OrtsPunktBean opb;
			try {
				opb = dj.run(startId, endId);

				displayWayDescription(opb, ortsMap);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Die Punkte konnten nicht verbunden werden", "Error", JOptionPane.ERROR_MESSAGE);
				frame.setVisible(false);
				frame.pack();
				frame.setVisible(true);
			}
			
			for(OrtDTO ort : orte) {
				Integer strHash = ortsMap.get(ort.getPointId().intValue());
				if(ort.getPointId() == startId || ort.getPointId() == endId) {
					ort.setShortestWay(OrtDTO.STARTENDPOINT);
					streetMap.put(strHash, strHash);
				}
				else if(strHash != null) {
					ort.setShortestWay(OrtDTO.SHORTESTWAY);
					streetMap.put(strHash, strHash);
				}
				else {
					ort.setShortestWay(OrtDTO.DEFAULT);
				}
			}
			
			for(StrasseComponentDTO sc : strassen) {
				if(streetMap.get(sc.hashCode()) != null) {
					sc.setShortestWay(true);
				}
				else {
					sc.setShortestWay(false);
				}
			}
			
			gc.repaint();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Popup wird angezeigt mit einem Textuellen Routenverlauf
	 * @param opb
	 * @param ortsMap
	 */
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
		double km;
		
		for(int i = opb.getWay().size()-1; i >=0; i--) {
			
			Integer pktHash = null;
			pktHash = (int) (opb.getWay().get(i).getPointX()+opb.getWay().get(i).getPointY());
			
			if(opb.getWay().get(i).getPrevPunkt() != null) {
				pktHash = pktHash+Integer.valueOf((int) (opb.getWay().get(i).getPrevPunkt().getPointX()+opb.getWay().get(i).getPrevPunkt().getPointY()));
				km = opb.getWay().get(i).getDistanz()-opb.getWay().get(i).getPrevPunkt().getDistanz();
				
				if(i == opb.getWay().size()-2) {
					ausgabe = "Strecke von "+opb.getWay().get(i).getPrevPunkt().getPunkteBeschreibung()+" in Richtung "+opb.getWay().get(i).getPunkteBeschreibung()
							+" "+km+ " km folgen";
				}
				else{
					ausgabe = "In Richtung "+opb.getWay().get(i).getPunkteBeschreibung() +" abbiegen und "+km +" km dem Streckenverlauf forlgen";
				}
				
				ortsMap.put(opb.getWay().get(i).getPunkteId().intValue(), pktHash);
			}
			
			center.add(new JLabel(ausgabe), gc);
			gc.gridy++;
			
		}
		gc.gridy++;
		f.add(center);
		Dimension d = f.getPreferredSize();
		int height  = (int) d.getHeight()+50;
		int width  = (int) d.getWidth()+50;
		f.setPreferredSize(new Dimension(width, height));
		f.pack();
		f.setVisible(true);
		center.add(new JLabel("Sie haben "+opb.getPunkteBeschreibung()+" nach "+opb.getDistanz()+"km erreicht."), gc);
	}

}
