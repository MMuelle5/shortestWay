package com.mima.app.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mima.app.Dijkstra;
import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.GuiRelevantBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock;

public class FindWayAction implements ActionListener {

	private GuiRelevantBean bean;
	
	public FindWayAction(GuiRelevantBean bean) {
		super();
		this.bean = bean;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BerechnungsOptionen calc = new BerechnungsOptionen();
		calc.setMautAllowed(bean.getMaut().isSelected());
		calc.setOption(String.valueOf(bean.getOption().getSelectedItem()));
		
		StrasseDao dao = new StrassenMock();
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(dao), calc);
		
	}

}
