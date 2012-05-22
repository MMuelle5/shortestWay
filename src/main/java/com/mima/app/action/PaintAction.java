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
		
		if(e!=null && GraphicalUtils.NEWPOINT.equals(e.getActionCommand())) {
			System.out.println(pb.getxAxis());
			System.out.println(pb.getyAxis());
//			String name = JOptionPane.showInputDialog("Orstzbezeichnug eingeben:", "neuer Ort");
//			if(StringUtils.isNotEmpty(name)) {
//				orte.add(new OrtsPunktComponent(pb.getxAxis(), pb.getyAxis(), name));
//			}
			orte.add(new OrtsPunktComponent(pb.getxAxis(), pb.getyAxis(), String.valueOf(orte.size()+1)));
		}
		else {
			if(pb.getxAxis() != 0 && pb.getyAxis() != 0 && pb.getxAxisEnd() != 0 && pb.getyAxisEnd() != 0) {
//System.out.println((pb.getxAxis() - pb.getxAxisEnd()));
//System.out.println((pb.getyAxis() - pb.getyAxisEnd()));
//System.out.println(pb.getxAxis()+", "+pb.getxAxisEnd()+", "+pb.getyAxis()+", "+pb.getyAxisEnd());
				
				//Sonst gehen wir davon aus, dass er aus versehen geklickt hat
				if((50 < (pb.getxAxis() - pb.getxAxisEnd()) || (pb.getxAxis() - pb.getxAxisEnd()) < -50)
					||(50 < (pb.getyAxis() - pb.getyAxisEnd()) || (pb.getyAxis() - pb.getyAxisEnd()) < -50)) {
					System.out.println(pb.getxAxis()+"/"+pb.getyAxis());
					System.out.println(pb.getxAxisEnd()+"/"+pb.getyAxisEnd());
					boolean isStartSet = false;
					boolean isEndSet = false;
					StrasseComponent sc = new StrasseComponent();
					for(OrtsPunktComponent ort : orte) {
						System.out.println("Ort: "+ort.getxStart()+"/"+ort.getyStart());
						if(isInRange((pb.getxAxis()-ort.getxStart()), 75) && isInRange((pb.getyAxis()- ort.getyStart()), 75)) {
							sc.setxStart(ort.getxStart());
							sc.setyStart(ort.getyStart());
							
							isStartSet = true;
						}
						else if(isInRange((pb.getxAxisEnd() - ort.getxStart()), 75) && isInRange((pb.getyAxisEnd() - ort.getyStart()), 75)) {
							sc.setxEnd(ort.getxStart());
							sc.setyEnd(ort.getyStart());

							isEndSet = true;
						}
						
						if(isStartSet &&isEndSet) {
							strassen.add(sc);
							break;
						}
					}
				}
			}
		}

		try {
			Thread.sleep(150);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		p.repaint();
	}
	
	private boolean isInRange(int val, int range) {
		return val > 0 && val < range;
	}
}
