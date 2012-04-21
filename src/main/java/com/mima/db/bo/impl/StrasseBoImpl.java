package com.mima.db.bo.impl;

import java.util.List;

import com.mima.db.bo.StrasseBo;
import com.mima.db.dao.StrasseDao;
import com.mima.db.exception.BoException;
import com.mima.db.model.Strasse;

public class StrasseBoImpl implements StrasseBo {

	private StrasseDao dao;
	
	public StrasseBoImpl(StrasseDao dao) {
		super();
		this.dao = dao;
	}



	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktId) throws BoException {
		return dao.findStreetsByStartPoint(startPunktId);
	}



	@Override
	public Strasse findStartPointById(Long startPunktId) throws BoException {
		return dao.findStartPointById(startPunktId);
	}

	

}
