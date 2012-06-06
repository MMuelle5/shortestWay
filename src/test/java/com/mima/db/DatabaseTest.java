package com.mima.db;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mima.db.dao.PointDao;
import com.mima.db.dao.StrasseDao;
import com.mima.db.daofactory.DAOFactory;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseDTO;

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
	public void testPaketStatus() throws SQLException {
		List<StrasseDTO> retVal = dao.findStreetsByStartPoint(Long.valueOf(1));
		assertNotNull(retVal);
		assertTrue(retVal.size()>0);
	}
	
	@Test
	public void testGetAllPoints() throws SQLException {
		List<OrtDTO> retVal = pdao.findAllPoints();
		assertNotNull(retVal);
		assertTrue(retVal.size()>0);
	}

	@Test
	public void testGetPointByAxis() throws SQLException {
		OrtDTO retVal = pdao.findPointByAxis(1,1);
		assertNotNull(retVal);
	}

}
