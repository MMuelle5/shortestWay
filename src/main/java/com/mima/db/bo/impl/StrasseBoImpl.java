package com.mima.db.bo.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mima.db.bo.StrasseBo;
import com.mima.db.dao.StrasseDao;
import com.mima.db.exception.BoException;
import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

public class StrasseBoImpl implements StrasseBo {

	private StrasseDao dao;
	
	public StrasseBoImpl(StrasseDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId, boolean isMautAllowed) throws BoException {
		try {
			return dao.findStreetsByStartPoint(startPunktId, isMautAllowed);
		} catch (SQLException e) {
			throw new BoException(e);
		}
	}

	@Override
	public List<StrasseComponentDTO> findAllStreetsToDisplay() throws BoException {
		try {
			return dao.findAllStreetsToDisplay();
		} catch (SQLException e) {
			throw new BoException(e);
		}
	}

	@Override
	public int mergeOrDelStrasse(StrasseDTO dto) throws BoException {
		try {

			StrasseDTO gegenRichtungDto = new StrasseDTO();
			gegenRichtungDto.initGegenrichtung(dto);
			
			if(dto.getSpeed()== 50) {
				dao.createStrasse(dto);
				dao.createStrasse(gegenRichtungDto);
				return 1;
			}
			else if(dto.getSpeed() != 0) {
				dao.updateStrasse(dto);
				dao.updateStrasse(gegenRichtungDto);
				return 2;
			}
			else {
				dao.deleteStrasse(dto);
				dao.deleteStrasse(gegenRichtungDto);
				return 3;
			}
		} catch (SQLException e) {
			throw new BoException(e);
		}
	}

	@Override
	public Map<Integer, StrasseComponentDTO> deleteStreetsByPointId(Long pointId) throws BoException {
		
		try {
			return dao.deleteStreetsByPointId(pointId);
		} catch (SQLException e) {
			throw new BoException(e);
		}
	}
}
