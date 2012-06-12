package com.mima.db.dao;

import java.sql.SQLException;
import java.util.List;

import com.mima.db.model.OrtDTO;

public interface PointDao {

	public OrtDTO findPointByAxis(int punktX, int punktY) throws SQLException;
	
	public Long findPointIdByName(String name) throws SQLException;

	public List<OrtDTO> findAllPoints() throws SQLException;

	public OrtDTO createPoint(OrtDTO dto) throws SQLException;

	public void deletePoint(OrtDTO dto) throws SQLException;
}
