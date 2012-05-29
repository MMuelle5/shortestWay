package com.mima.app.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import com.mima.app.gui.GraphicalComponents;
import com.mima.app.gui.GraphicalUtils;
import com.mima.app.gui.PaintBean;
import com.mima.db.bo.PointBo;
import com.mima.db.bo.StrasseBo;
import com.mima.db.bo.impl.PointBoImpl;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.daofactory.DAOFactory;
import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

public class PaintAction implements ActionListener{

	private JPanel p;
	private List<OrtDTO> orte;
	private List<StrasseComponentDTO> strassen;
	private PaintBean pb;
	private StrasseBo sbo;
	private PointBo pbo;
	

	public PaintAction(GraphicalComponents graphicalComponents, List<OrtDTO> orte2, List<StrasseComponentDTO> str, PaintBean pb) {
		this.p = graphicalComponents;
		this.orte = orte2;
		this.strassen = str;
		this.pb = pb;
		DAOFactory df = DAOFactory.getInstance();
		sbo = new StrasseBoImpl(df.getStrasseDao());
		pbo = new PointBoImpl(df.getPointDao());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e!=null && GraphicalUtils.NEWPOINT.equals(e.getActionCommand())) {
			OrtDTO dto = new OrtDTO(pb.getxAxis(), pb.getyAxis(), String.valueOf(orte.size()+1));
			try {
				dto = pbo.createPoint(dto);
			} catch (BoException e1) {
				e1.printStackTrace();
			}
			orte.add(dto);
		}
		else {
			if(pb.getxAxis() != 0 && pb.getyAxis() != 0 && pb.getxAxisEnd() != 0 && pb.getyAxisEnd() != 0) {
				
				//Sonst gehen wir davon aus, dass er aus versehen geklickt hat
				if((50 < (pb.getxAxis() - pb.getxAxisEnd()) || (pb.getxAxis() - pb.getxAxisEnd()) < -50)
					||(50 < (pb.getyAxis() - pb.getyAxisEnd()) || (pb.getyAxis() - pb.getyAxisEnd()) < -50)) {
					System.out.println(pb.getxAxis()+"/"+pb.getyAxis());
					System.out.println(pb.getxAxisEnd()+"/"+pb.getyAxisEnd());
					boolean isStartSet = false;
					boolean isEndSet = false;
					StrasseComponentDTO sc = new StrasseComponentDTO();
					for(OrtDTO ort : orte) {
						System.out.println("Ort: "+ort.getPointX()+"/"+ort.getPointY());
						if(isInRange((pb.getxAxis()-ort.getPointX()), 75) && isInRange((pb.getyAxis()- ort.getPointY()), 75)) {
							sc.setxStart(ort.getPointX());
							sc.setyStart(ort.getPointY());
							sc.setStartId(ort.getPointId());
							isStartSet = true;
						}
						else if(isInRange((pb.getxAxisEnd() - ort.getPointX()), 75) && isInRange((pb.getyAxisEnd() - ort.getPointY()), 75)) {
							sc.setxEnd(ort.getPointX());
							sc.setyEnd(ort.getPointY());
							sc.setEndId(ort.getPointId());
							isEndSet = true;
						}
						
						if(isStartSet &&isEndSet) {
							break;
						}
					}
					
					if(isStartSet &&isEndSet) {
						for(StrasseComponentDTO sdto : strassen) {
							if((sdto.getStartId().equals(sc.getStartId()) || sdto.getStartId() == sc.getStartId())
								&& (sdto.getEndId().equals(sc.getEndId()) || sdto.getEndId() == sc.getEndId())) {
								
								sc.incSpeed();
								break;
							}
						}
						try {
							StrasseDTO sDto = new StrasseDTO();
							sDto.setStartPunktId(sc.getStartId());
							sDto.setEndPunktId(sc.getEndId());
							sDto.setSpeed(sc.getSpeed());
							
							int width = sc.getxStart()-sc.getxEnd();
							int height = sc.getyStart()-sc.getyEnd();
							if(width < 0) {
								width = width *-1;
							}
							if(height < 0) {
								height = height *-1;
							}
							
							int status = sbo.mergeOrDelStrasse(sDto);
							if(status==1) {
								strassen.add(sc);
							}
							else {
								strassen.remove(sc);
								if(status == 2) {
									strassen.add(sc);
								}
							}
						} catch (BoException e1) {
							e1.printStackTrace();
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
