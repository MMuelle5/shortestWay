package com.mima.db.dao;

import java.util.List;

import com.mima.db.model.OrtDTO;
import com.mima.db.model.Strasse;

public interface StrasseDao {

	public List<OrtDTO> findAllPoints();

	public List<Strasse> findStreetsByStartPoint(Long startPunktId);

	public OrtDTO findPointByAxis(Long punktX, Long punktY);
}
