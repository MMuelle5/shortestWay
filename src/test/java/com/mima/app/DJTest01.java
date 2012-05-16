package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock01;


public class DJTest01 {

	@Before
	public void init() {
		StrasseDao str = new StrassenMock01();
		Dijkstra.init(new StrasseBoImpl(str));
	}
	
	@Test
	public void testDJ01() {
		OrtsPunktBean opb;
		try {
			opb = Dijkstra.run(new Long(1), new Long(5));
			assertTrue(true);
			assertEquals(9, opb.getDistanz(), 0);
			assertEquals("A, C, D, E", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
