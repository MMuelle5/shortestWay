package com.mima.db.bo;

import java.util.List;

import com.mima.db.exception.BoException;
import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

public interface StrasseBo {

	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId) throws BoException;
	
	public List<StrasseComponentDTO> findAllStreetsToDisplay() throws BoException;
	
	/**
	 * Rueckgabewerte:
	 * 	1=insert
	 * 	2=update
	 * 	3=delete
	 * @param dto
	 * @return
	 * @throws BoException
	 */
	public int mergeOrDelStrasse(StrasseDTO dto) throws BoException;
	
}
