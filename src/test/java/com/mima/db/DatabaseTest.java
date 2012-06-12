package com.mima.db;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.mima.db.dao.PointDao;
import com.mima.db.dao.StrasseDao;
import com.mima.db.daofactory.DAOFactory;

public class DatabaseTest {

	private StrasseDao dao;
	private PointDao pdao;

	@Before
	public void initialize() {
		DAOFactory daof = DAOFactory.getInstance();
		dao = daof.getStrasseDao();
		pdao = daof.getPointDao();
	}

	@Test
	public void testStreetByStartPoint() throws SQLException {
		dao.findStreetsByStartPoint(Long.valueOf(1));
	}
	
	@Test
	public void testGetAllPoints() throws SQLException {
		pdao.findAllPoints();
	}

	@Test
	public void testGetPointByAxis() throws SQLException {
		pdao.findPointByAxis(1,1);
	}

}
