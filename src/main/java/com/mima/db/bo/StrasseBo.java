package com.mima.db.bo;

import java.util.List;

import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.Strasse;

public interface StrasseBo {

	public List<Strasse> findStreetsByStartPoint(Long startPunktId) throws BoException;
	
	public List<OrtDTO> findAllPointIds() throws BoException;

	public Strasse findPointByAxis(Long endPunktX, Long endPunktY) throws BoException;

}
