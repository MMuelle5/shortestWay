package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock02;


public class DJTest02 {

	@Before
	public void init() {
		StrasseDao str = new StrassenMock02();
		Dijkstra.init(new StrasseBoImpl(str));
	}
	
	@Test
	public void testDJ02() {
		OrtsPunktBean opb;
		try {
			opb = Dijkstra.run(new Long(1), new Long(6));
			assertTrue(true);
			assertEquals(16, opb.getDistanz(), 0);
			assertEquals("s, v2, v3, v4, v5", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
