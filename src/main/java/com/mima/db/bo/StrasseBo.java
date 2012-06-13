package com.mima.db.bo;

import java.util.List;

import com.mima.db.exception.BoException;
import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

/**
 * 
 * Business-Object fuer alle Strassen-DB-Andbinungen
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public interface StrasseBo {

	/**
	 * 
	 * @param startPunktId
	 * @param isMautAllowed falls false --> gebuehrenpflichtige Strassen werden nicht beruecksichtig
	 * @return rueckgabe aller Strassen, die von einem bestimmten Punkt ausgehen
	 * @throws BoException
	 */
	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId, boolean isMautAllowed) throws BoException;
	
	/**
	 * @return Alle Strassen inklusive deren Anzeigeoptionen
	 * @throws BoException
	 */
	public List<StrasseComponentDTO> findAllStreetsToDisplay() throws BoException;
	
	/**
	 * Entscheidet, was mit dem Record passieren soll (erstellen/updaten/loeschen)
	 * und macht dies gleich auch fuer die Gegenrichtung
	 * @param dto
	 * @return 1=insert; 2=update; 3=delete
	 * @throws BoException
	 */
	public int mergeOrDelStrasse(StrasseDTO dto) throws BoException;
	
}
