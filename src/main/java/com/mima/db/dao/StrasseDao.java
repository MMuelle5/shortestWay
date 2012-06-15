package com.mima.db.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

/**
 * Umsetzung aller DB-Zugriffe, die im PointBo verlangt sind
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public interface StrasseDao {

	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId, boolean isMautAllowed) throws SQLException;

	public List<StrasseComponentDTO> findAllStreetsToDisplay() throws SQLException;

	/**
	 * Methode sollte nur via mergeOrDelStrasse aufgerufen werden
	 * @param dto
	 * @throws SQLException
	 */
	public void createStrasse(StrasseDTO dto) throws SQLException;

	/**
	 * 
	 * Methode sollte nur via mergeOrDelStrasse aufgerufen werden
	 * @param dto
	 * @throws SQLException
	 */
	public void updateStrasse(StrasseDTO dto) throws SQLException;

	/**
	 * Methode sollte nur via mergeOrDelStrasse aufgerufen werden
	 * @param dto
	 * @throws SQLException
	 */
	public void deleteStrasse(StrasseDTO dto) throws SQLException;

	public Map<Integer, StrasseComponentDTO> deleteStreetsByPointId(Long pointId) throws SQLException;

}
