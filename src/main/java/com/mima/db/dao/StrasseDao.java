package com.mima.db.dao;

import java.util.List;

import com.mima.db.model.Strasse;

public interface StrasseDao {
	
	public Strasse findStartPointById(Long startPointId);
	
	public List<Strasse> findStreetsByStartPoint(Long startPointId);
}
