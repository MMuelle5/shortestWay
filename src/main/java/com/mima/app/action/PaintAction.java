package com.mima.app.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

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

	private List<OrtDTO> orte;
	private List<StrasseComponentDTO> strassen;
	private PaintBean pb;
	private StrasseBo sbo;
	private PointBo pbo;
	private JFrame frame;
	

	public PaintAction(List<OrtDTO> orte2, List<StrasseComponentDTO> str, PaintBean pb, JFrame frame) {
		this.orte = orte2;
		this.strassen = str;
		this.pb = pb;
		this.frame = frame;
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
			repaint();
		}
		else {
			if(pb.getxAxis() != 0 && pb.getyAxis() != 0 && pb.getxAxisEnd() != 0 && pb.getyAxisEnd() != 0) {
				
				//Sonst gehen wir davon aus, dass er aus versehen geklickt hat
				if((50 < (pb.getxAxis() - pb.getxAxisEnd()) || (pb.getxAxis() - pb.getxAxisEnd()) < -50)
					||(50 < (pb.getyAxis() - pb.getyAxisEnd()) || (pb.getyAxis() - pb.getyAxisEnd()) < -50)) {
					int existingIdx = 0;
					boolean isStartSet = false;
					boolean isEndSet = false;
					StrasseComponentDTO sc = new StrasseComponentDTO();
					
					for(OrtDTO ort : orte) {
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
						sc.setSpeed(50);
						int i = 0;
						for(StrasseComponentDTO sdto : strassen) {
							if(sdto.hashCode() == sc.hashCode()) {
								sdto.incSpeed();
								sc.setSpeed(sdto.getSpeed());
								existingIdx = i;
								break;
							}
							i++;
						}
						try {
							StrasseDTO sDto = new StrasseDTO();
							sDto.setStartPunktId(sc.getStartId());
							sDto.setEndPunktId(sc.getEndId());
							sDto.setSpeed(sc.getSpeed());
							sDto.setDistanz(clacLength(sc.getyStart()-sc.getyEnd(), sc.getxStart()-sc.getxEnd()));
							
							int status = sbo.mergeOrDelStrasse(sDto);
							
							if(status==1) {
								strassen.add(sc);
							}
							else if(status == 2) {
								strassen.get(existingIdx).setSpeed(sc.getSpeed());
							}
							else if(status == 3){
								strassen.remove(existingIdx);	
							}
							repaint();
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

//		p.repaint();

	}

	private void repaint() {

		frame.setVisible(false);
		frame.pack();
		frame.setVisible(true);
	}
	
	private double clacLength(int height, int width) {

		if(width < 0) {
			width = width *-1;
		}
		if(height < 0) {
			height = height *-1;
		}

		double dist = Math.sqrt(width*width+height*height);
		
		return dist/100;
	}
	private boolean isInRange(int val, int range) {
		return val > 0 && val < range;
	}
}
