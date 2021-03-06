package com.mima.app.gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.mima.app.action.PaintAction;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseComponentDTO;

/**
 * Zeichnungsmaske im Zentralen Bereich
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public class GraphicalComponents extends JPanel {

	private JPopupMenu pmenu = new JPopupMenu();
	private JMenuItem newPoint = new JMenuItem(GraphicalUtils.NEWPOINT);
	private List<OrtDTO> orte = new ArrayList<OrtDTO>();
	private List<StrasseComponentDTO> strassen = new ArrayList<StrasseComponentDTO>();
	private PaintBean pb = new PaintBean();
	private PaintAction pa;
	private boolean isMousePressed = false;

	public GraphicalComponents(JFrame frame, List<StrasseComponentDTO> str, List<OrtDTO> orte2) {
		super();
		pmenu.add(newPoint);
		this.strassen = str;
		this.orte = orte2;
		
		pa = new PaintAction(orte, strassen, pb, frame);
		newPoint.addActionListener(pa);

		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				if (me.isPopupTrigger()) {
					for(OrtDTO ort : orte) {
						if(ort.getPointX()<me.getX() && (ort.getPointX()+75) > me.getX()
							&& ort.getPointY()<me.getY() && (ort.getPointY()+75) > me.getY()) {
							newPoint.setText(GraphicalUtils.DELETE);
							pb.setPointId(ort.getPointId());
							break;
						}
						else {
							newPoint.setText(GraphicalUtils.NEWPOINT);
						}
					}
					pmenu.show(me.getComponent(), me.getX(), me.getY());
					pb.setxAxis(me.getX());
					pb.setyAxis(me.getY());
 
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				else if(isMousePressed) {
					isMousePressed = false;
					pb.setxAxisEnd(me.getX());
					pb.setyAxisEnd(me.getY());
					pa.actionPerformed(null);
				}
				
			}
			public void mousePressed(MouseEvent me) {
				if (!me.isPopupTrigger()) {
					isMousePressed = true;
					pb.setxAxis(me.getX());
					pb.setyAxis(me.getY());
				}
			}
		});

	}

	public void paintComponent(Graphics g) {

		for (StrasseComponentDTO c : strassen) {
			if (c.getxEnd() != 0) {
				GraphicalUtils.drawLine(g, c.getxStart(), c.getyStart(),
						c.getxEnd(), c.getyEnd(), c.getSpeed(), c.isShortestWay());
			}
		}

		for (OrtDTO c : orte) {
			GraphicalUtils.drawOval(g, c.getPointX(), c.getPointY(),
					c.getDescription(), c.getShortestWay());
		}
	}

}
