package com.mima.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.PointDao;
import com.mima.db.dao.utility.DaoUtil;
import com.mima.db.daofactory.DAOFactory;
import com.mima.db.model.OrtDTO;

public class PointDaoImpl implements PointDao{

	private static final String FINDALLPOINTS = "SELECT id, xAxis, yAxis, name FROM WayPoint";
	private static final String FINDPOINTBYAXIS = "SELECT id, xAxis, yAxis, name FROM WayPoint WHERE xAxis=? AND yAxis=?";
	private static final String CREATEPOINT = "INSERT INTO WayPoint (xAxis, yAxis, name) values(?,?,?)";
	private static final String FINDPOINTBYNAME = "SELECT id FROM WayPoint WHERE name=?";
	private static final String DELETEPOINTBYID = "DELETE FROM WayPoint WHERE id=?";

	private DAOFactory daoFactory;
	
	public PointDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public List<OrtDTO> findAllPoints() throws SQLException {
		List<OrtDTO> retVal = new ArrayList<OrtDTO>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Connection connection = daoFactory.getConnection();
		preparedStatement = DaoUtil.prepareStatement(connection, FINDALLPOINTS, false, new Object[0]);
        resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			OrtDTO ort = new OrtDTO();
			ort.setPointId(resultSet.getLong("id"));
			ort.setPointX(resultSet.getInt("xAxis"));
			ort.setPointY(resultSet.getInt("yAxis"));
			ort.setDescription(resultSet.getString("name"));
			retVal.add(ort);
		}
		return retVal;
	}

	@Override
	public OrtDTO findPointByAxis(int punktX, int punktY) throws SQLException {
		OrtDTO ort = new OrtDTO();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Connection connection = daoFactory.getConnection();
		preparedStatement = DaoUtil.prepareStatement(connection, FINDPOINTBYAXIS, false, new Object[]{punktX, punktY});
        resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			ort.setPointId(resultSet.getLong("id"));
			ort.setPointX(resultSet.getInt("xAxis"));
			ort.setPointY(resultSet.getInt("yAxis"));
			ort.setDescription(resultSet.getString("name"));
		}
		return ort;
	}

	@Override
	public OrtDTO createPoint(OrtDTO dto) throws SQLException {

        PreparedStatement preparedStatement = null;

        Connection connection = daoFactory.getConnection();
		preparedStatement = DaoUtil.prepareStatement(connection, CREATEPOINT, false, new Object[]{dto.getPointX(), dto.getPointY(), dto.getDescription()});
        preparedStatement.executeUpdate();

        return findPointByAxis(dto.getPointX(), dto.getPointY());
	}

	@Override
	public void deletePoint(OrtDTO dto) throws SQLException {

        PreparedStatement preparedStatement = null;

        Connection connection = daoFactory.getConnection();
		preparedStatement = DaoUtil.prepareStatement(connection, DELETEPOINTBYID, false, new Object[]{dto.getPointId()});
        preparedStatement.executeUpdate();
	}

	@Override
	public Long findPointIdByName(String name) throws SQLException {

        PreparedStatement preparedStatement = null;

        Connection connection = daoFactory.getConnection();
		preparedStatement = DaoUtil.prepareStatement(connection, FINDPOINTBYNAME, false, new Object[]{name});
        ResultSet rs = preparedStatement.executeQuery();
        Long retVal = null;
        
        while(rs.next()) {
        	retVal = rs.getLong("id");
        }

        return retVal;
	}
}
