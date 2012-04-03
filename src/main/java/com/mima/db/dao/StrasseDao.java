package com.mima.db.dao;

import java.util.List;

import com.mima.db.model.Strasse;

public interface StrasseDao {
	public List<Strasse> findStreetsByStartPoint(Long startPunktX, Long startPunktY);
}
