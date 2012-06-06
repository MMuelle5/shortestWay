package com.mima.db.bo;

import java.util.List;

import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;

public interface PointBo {

	public List<OrtDTO> findAllPointIds() throws BoException;

	public OrtDTO findPointByAxis(int endPunktX, int endPunktY) throws BoException;
	
	public OrtDTO createPoint(OrtDTO dto) throws BoException;
	
	public void deletePoint(OrtDTO dto) throws BoException;
}
