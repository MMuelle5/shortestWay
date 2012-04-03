package com.mima.db.bo;

import java.util.List;

import com.mima.db.exception.BoException;
import com.mima.db.model.Strasse;

public interface StrasseBo {

	public List<Strasse> findStreetsByStartPoint(Long startPunktX, Long startPunktY) throws BoException;
}
