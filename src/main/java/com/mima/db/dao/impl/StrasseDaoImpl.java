package com.mima.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.StrasseDao;
import com.mima.db.dao.exception.DAOException;
import com.mima.db.dao.utility.DaoUtil;
import com.mima.db.daofactory.DAOFactory;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.Strasse;
import com.mima.db.utils.HibernateDaoHelper;

public class StrasseDaoImpl extends HibernateDaoHelper implements StrasseDao {

	private static final String FINDSTREETBYSTARTPOINT = "SELECT StartPoint, EndPoint, Distance FROM Way WHERE StartPoint = ?";
	private static final String FINDALLPOINTS = "SELECT id, xAxis, yAxis, name FROM WayPoint";
	private static final String FINDPOINTBYAXIS = "SELECT id, xAxis, yAxis, name FROM WayPoint WHERE xAxis=? AND yAxis=?";

	private DAOFactory daoFactory;
	
	public StrasseDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktId) {
		
		List<Strasse> retVal = new ArrayList<Strasse>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            Connection connection = daoFactory.getConnection();
			preparedStatement = DaoUtil.prepareStatement(connection, FINDSTREETBYSTARTPOINT, false, new Object[]{startPunktId});
            resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Strasse s = new Strasse();
				s.setStartPunktId(resultSet.getLong("StartPoint"));
				s.setEndPunktId(resultSet.getLong("EndPoint"));
				s.setDistanz(resultSet.getLong("Distance"));
				retVal.add(s);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public List<OrtDTO> findAllPoints() {
		List<OrtDTO> retVal = new ArrayList<OrtDTO>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            Connection connection = daoFactory.getConnection();
			preparedStatement = DaoUtil.prepareStatement(connection, FINDALLPOINTS, false, new Object[0]);
            resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				OrtDTO ort = new OrtDTO();
				ort.setPointId(resultSet.getLong("id"));
				ort.setPointX(resultSet.getLong("xAxis"));
				ort.setPointY(resultSet.getLong("yAxis"));
				ort.setDescription(resultSet.getString("name"));
				retVal.add(ort);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public OrtDTO findPointByAxis(Long punktX, Long punktY) {
		OrtDTO ort = new OrtDTO();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            Connection connection = daoFactory.getConnection();
			preparedStatement = DaoUtil.prepareStatement(connection, FINDPOINTBYAXIS, false, new Object[]{punktX, punktY});
            resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				ort.setPointId(resultSet.getLong("id"));
				ort.setPointX(resultSet.getLong("xAxis"));
				ort.setPointY(resultSet.getLong("yAxis"));
				ort.setDescription(resultSet.getString("name"));
			}
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ort;
	}
}
