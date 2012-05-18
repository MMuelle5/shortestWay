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
import com.mima.app.bean.OrtsPunktComponent;
import com.mima.app.bean.StrasseComponent;

public class GraphicalComponents extends JPanel {

	private JPopupMenu pmenu = new JPopupMenu();
	private JMenuItem newPoint = new JMenuItem(GraphicalUtils.NEWPOINT);
	private JMenuItem newStreet = new JMenuItem(GraphicalUtils.NEWSTREET);
	private JMenuItem delete = new JMenuItem(GraphicalUtils.DELETE);
	private List<OrtsPunktComponent> orte = new ArrayList<OrtsPunktComponent>();
	private List<StrasseComponent> strassen = new ArrayList<StrasseComponent>();
	private PaintBean pb = new PaintBean();
	private PaintAction pa;

	public GraphicalComponents(JFrame frame) {
		super();
		pmenu.add(newPoint);
		pmenu.add(newStreet);
		pmenu.add(delete);
		System.out.println("hmm");

		int xAxisStart = 100;
		int yAxisStart = 50;
		int xAxisEnd = 200;
		int yAxisEnd = 20;

		OrtsPunktComponent c = new OrtsPunktComponent(xAxisStart, yAxisStart,
				"pktA");
		orte.add(c);
		StrasseComponent s = new StrasseComponent(xAxisStart, yAxisStart,
				xAxisEnd, yAxisEnd, 42);
		strassen.add(s);
		c = new OrtsPunktComponent(xAxisEnd, yAxisEnd, "pktB");
		orte.add(c);

		pa = new PaintAction(this, orte, strassen, pb);
		newPoint.addActionListener(pa);
		newStreet.addActionListener(pa);
		delete.addActionListener(pa);
	}

	public void paintComponent(Graphics g) {

		System.out.println("uff");
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				if (me.isPopupTrigger()) {
					pmenu.show(me.getComponent(), me.getX(), me.getY());
					pb.setxAxis(me.getX());
					pb.setyAxis(me.getY());

					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		System.out.println("ok");
		for (StrasseComponent c : strassen) {
			if (c.getxEnd() != 0) {
				GraphicalUtils.drawLine(g, c.getxStart(), c.getyStart(),
						c.getxEnd(), c.getyEnd());
			}
		}

		for (OrtsPunktComponent c : orte) {
			GraphicalUtils.drawOval(g, c.getxStart(), c.getyStart(),
					c.getName());
		}
	}

}
