package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock03;


public class DJTest03 {

	@Before
	public void init() {
		StrasseDao str = new StrassenMock03();
		Dijkstra.init(new StrasseBoImpl(str));
	}
	
	@Test
	public void testDJ03() {
		OrtsPunktBean opb;
		try {
			opb = Dijkstra.run(new Long(1), new Long(2));
			assertTrue(true);
			assertEquals(10, opb.getDistanz(), 0);
			assertEquals("A, B", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
