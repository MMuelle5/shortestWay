package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock;


public class DJTest2 {

	@Before
	public void init() {
		StrasseDao str = new StrassenMock2();
		Dijkstra.init(new StrasseBoImpl(str));
	}
	
	@Test
	public void testDJ2() {
		OrtsPunktBean opb;
		try {
			opb = Dijkstra.run(new Long(1), new Long(6));
			assertTrue(true);
			assertEquals(16, opb.getDistanz(), 0);
			assertEquals("A, D, C, E, F", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
