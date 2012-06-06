package com.mima.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.StrasseDao;
import com.mima.db.dao.utility.DaoUtil;
import com.mima.db.daofactory.DAOFactory;
import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;
import com.mima.db.utils.HibernateDaoHelper;

public class StrasseDaoImpl extends HibernateDaoHelper implements StrasseDao {

	private static final String FINDSTREETBYSTARTPOINT = "SELECT StartPoint, EndPoint, Distance, Speed, Toll FROM Way WHERE StartPoint = ?";
	private static final String ALLSTREETSTODISPLAY = "SELECT pStart.id AS StartId, pEnd.id AS EndId, " +
															 "pStart.xAxis AS startX, pStart.yAxis AS startY, " +
															" pEnd.xAxis AS endX, pEnd.yAxis AS endY, Distance, Speed, Toll " +
														" FROM shortestWay.Way w " +
														" INNER JOIN shortestWay.WayPoint pStart ON (pStart.id = w.StartPoint) " +
														" INNER JOIN shortestWay.WayPoint pEnd ON (pEnd.id = w.EndPoint)";
	private static final String CREATESTREET = "INSERT INTO Way (StartPoint, EndPoint, Distance, Speed, Toll) values(?,?,?,?,?)";
	
	private DAOFactory daoFactory;
	
	public StrasseDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId) throws SQLException {
		
		List<StrasseDTO> retVal = new ArrayList<StrasseDTO>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Connection connection = daoFactory.getConnection();
		preparedStatement = DaoUtil.prepareStatement(connection, FINDSTREETBYSTARTPOINT, false, new Object[]{startPunktId});
        resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			StrasseDTO s = new StrasseDTO();
			s.setStartPunktId(resultSet.getLong("StartPoint"));
			s.setEndPunktId(resultSet.getLong("EndPoint"));
			s.setDistanz(resultSet.getLong("Distance"));
			s.setSpeed(resultSet.getInt("Speed"));
			s.setMaut(resultSet.getBoolean("Toll"));
			retVal.add(s);
		}
		return retVal;
	}

	@Override
	public List<StrasseComponentDTO> findAllStreetsToDisplay()
			throws SQLException {

		List<StrasseComponentDTO> retVal = new ArrayList<StrasseComponentDTO>();
        ResultSet resultSet = null;

        Connection connection = daoFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ALLSTREETSTODISPLAY);
		
        resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			StrasseComponentDTO s = new StrasseComponentDTO();
			s.setStartId(resultSet.getLong("StartId"));
			s.setEndId(resultSet.getLong("EndId"));
			s.setxStart(resultSet.getInt("startX"));
			s.setyStart(resultSet.getInt("startY"));
			s.setxEnd(resultSet.getInt("endX"));
			s.setyEnd(resultSet.getInt("endY"));
			s.setDistanz(resultSet.getLong("Distance"));
			s.setSpeed(resultSet.getInt("Speed"));
			s.setMaut(resultSet.getBoolean("Toll"));
			retVal.add(s);
		}
		return retVal;
	}

	@Override
	public void createStrasse(StrasseDTO dto) throws SQLException {

        PreparedStatement preparedStatement = null;

        Connection connection = daoFactory.getConnection();
		preparedStatement = DaoUtil.prepareStatement(connection, CREATESTREET, false, new Object[]{dto.getStartPunktId(), dto.getEndPunktId(), dto.getDistanz(), dto.getSpeed(), dto.isMaut()});
        preparedStatement.executeUpdate();

		
	}

	@Override
	public void updateStrasse(StrasseDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStrasse(StrasseDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
