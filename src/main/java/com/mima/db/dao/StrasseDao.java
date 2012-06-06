package com.mima.db.dao;

import java.sql.SQLException;
import java.util.List;

import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

public interface StrasseDao {

	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId) throws SQLException;

	public List<StrasseComponentDTO> findAllStreetsToDisplay() throws SQLException;

	public void createStrasse(StrasseDTO dto) throws SQLException;

	public void updateStrasse(StrasseDTO dto) throws SQLException;

	public void deleteStrasse(StrasseDTO dto) throws SQLException;

}
