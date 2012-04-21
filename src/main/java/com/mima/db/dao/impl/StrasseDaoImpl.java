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
import com.mima.db.model.Strasse;
import com.mima.db.utils.HibernateDaoHelper;

public class StrasseDaoImpl extends HibernateDaoHelper implements StrasseDao {

	private static final String FINDBYSTARTPOINT = "SELECT startpointX, startpointY, endpointX, endpointY, Distance FROM Way WHERE startpointId = ?";

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
			preparedStatement = DaoUtil.prepareStatement(connection, FINDBYSTARTPOINT, false, new Object[]{startPunktId});
            resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Strasse s = new Strasse();
				s.setStartPunktX(resultSet.getLong("startpointX"));
				s.setStartPunktY(resultSet.getLong("startpointY"));
				s.setEndPunktX(resultSet.getLong("endpointX"));
				s.setEndPunktY(resultSet.getLong("endpointY"));
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
	public Strasse findStartPointById(Long startPointId) {
		// TODO Auto-generated method stub
		return null;
	}

}
