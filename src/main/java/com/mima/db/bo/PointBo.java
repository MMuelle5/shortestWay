package com.mima.db.bo;

import java.util.List;

import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;

/**
 * Business-Object fuer alle Punkte-DB-Andbinungen
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public interface PointBo {

	/**
	 * Gibt alle Punkte zurueck
	 * @return
	 * @throws BoException
	 */
	public List<OrtDTO> findAllPointIds() throws BoException;

	/**
	 * DJ-Algo ist auf PunktId basiert;
	 * Fuer ein besseres Userhandling, wird aber nach den Namen gesucht
	 * @param name
	 * @return
	 * @throws BoException
	 */
	public Long findPointIdByName(String name) throws BoException;
	
	/**
	 * Moeglichkeit, mit X- und Y-Koordinaten einen Punkt zu finden
	 * @param endPunktX
	 * @param endPunktY
	 * @return
	 * @throws BoException
	 */
	public OrtDTO findPointByAxis(int endPunktX, int endPunktY) throws BoException;
	
	/**
	 * Punkt der Datenbank hinzufuegen
	 * @param dto
	 * @return dto (inkl. Id)
	 * @throws BoException
	 */
	public OrtDTO createPoint(OrtDTO dto) throws BoException;
	
	/**
	 * Punkt loeschen
	 * @param dto
	 * @throws BoException
	 */
	public void deletePoint(OrtDTO dto) throws BoException;
}
