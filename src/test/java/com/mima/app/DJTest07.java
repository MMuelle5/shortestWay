package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock07;


public class DJTest07 {
	
	@Test
	public void testDJ07() {
		OrtsPunktBean opb;
		StrasseDao str = new StrassenMock07();
		BerechnungsOptionen b = new BerechnungsOptionen();
		b.setMautAllowed(false);
		b.setOption(BerechnungsOptionen.SHORTESTWAY);
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(str), b);
		try {
			opb = dj.run(new Long(1), new Long(6));
			assertTrue(true);
			assertEquals(18, opb.getDistanz(), 0);
			assertEquals("A, B, G, H, E, F", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
