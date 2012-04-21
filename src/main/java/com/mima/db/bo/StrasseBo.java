package com.mima.db.bo;

import java.util.List;

import com.mima.db.exception.BoException;
import com.mima.db.model.Strasse;

public interface StrasseBo {

	public List<Strasse> findStreetsByStartPoint(Long startPunktId) throws BoException;

	public Strasse findStartPointById(Long startPunktId) throws BoException;
}
