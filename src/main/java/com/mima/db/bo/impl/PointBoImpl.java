package com.mima.db.bo.impl;

import java.sql.SQLException;
import java.util.List;

import com.mima.db.bo.PointBo;
import com.mima.db.dao.PointDao;
import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;

public class PointBoImpl implements PointBo{

	private PointDao dao;
	
	public PointBoImpl(PointDao dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<OrtDTO> findAllPointIds() throws BoException {
		try {
			return dao.findAllPoints();
		} catch (SQLException e) {
			throw new BoException(e);
		}
	}

	@Override
	public OrtDTO findPointByAxis(int punktX, int punktY)
			throws BoException {
		try {
			return dao.findPointByAxis(punktX, punktY);
		} catch (SQLException e) {
			throw new BoException(e);
		}
	}

	@Override
	public OrtDTO createPoint(OrtDTO dto) throws BoException {
		try {
			return dao.createPoint(dto);
		} catch (SQLException e) {
			throw new BoException(e);
		}
	}

	@Override
	public void deletePoint(OrtDTO dto) throws BoException {
		try {
			dao.deletePoint(dto);
		} catch (SQLException e) {
			throw new BoException(e);
		}
	}
}
