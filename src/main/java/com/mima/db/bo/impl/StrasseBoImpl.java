package com.mima.db.bo.impl;

import java.util.List;

import com.mima.db.bo.StrasseBo;
import com.mima.db.dao.StrasseDao;
import com.mima.db.exception.BoException;
import com.mima.db.model.Strasse;

public class StrasseBoImpl implements StrasseBo {

	StrasseDao dao;
	
	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktX, Long startPunktY) throws BoException {
		return dao.findStreetsByStartPoint(startPunktX, startPunktY);
	}

	

}
