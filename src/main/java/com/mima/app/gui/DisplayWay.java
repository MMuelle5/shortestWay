package com.mima.app.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mima.app.action.FindWayAction;
import com.mima.app.bean.GuiRelevantBean;
import com.mima.db.bo.PointBo;
import com.mima.db.bo.StrasseBo;
import com.mima.db.bo.impl.PointBoImpl;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.daofactory.DAOFactory;
import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseComponentDTO;

/**
 * Anzeigepanel für linke Hälfte vom GUI
 * zuständig für Wegpunkte und Strecke
 *
 * @author i10b@zhaw: M. Müller / M. Ott
 *
 */
public class DisplayWay {

	private JFrame frame;
	private GuiRelevantBean bean = new GuiRelevantBean();
	private FindWayAction action;
	private List<StrasseComponentDTO> str;
	private List<OrtDTO> orte;
	
	public DisplayWay() {
		super();
		frame = new JFrame("Routensucher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bean.setNavi(new JPanel(new GridBagLayout()));
		
		DAOFactory daof = DAOFactory.getInstance();
		PointBo pbo = new PointBoImpl(daof.getPointDao());
		StrasseBo sbo = new StrasseBoImpl(daof.getStrasseDao());
		try {
			orte = pbo.findAllPointIds();
			str = sbo.findAllStreetsToDisplay();
		} catch (BoException e) {
			e.printStackTrace();
		}
	}

	public void displayContentPanel() {
		
		bean.setPanel(new JPanel(new BorderLayout()));

		GraphicalComponents gc = new GraphicalComponents(frame, str, orte);
		
		bean.getPanel().add(gc, BorderLayout.CENTER);
		
		bean.getPanel().add(bean.getNavi(), BorderLayout.EAST);
		

		action = new FindWayAction(bean, frame, str, orte, gc);
		DisplayEast.getNavigation(bean, action);

		
		frame.add(bean.getPanel());
		frame.setPreferredSize(new Dimension(800,800));
		frame.pack();
		frame.setVisible(true);
	}
	
}
