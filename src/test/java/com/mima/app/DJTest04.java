package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock04;


public class DJTest04 {
	
	@Test
	public void testDJ04() {
		OrtsPunktBean opb;
		StrasseDao str = new StrassenMock04();
		BerechnungsOptionen b = new BerechnungsOptionen();
		b.setMautAllowed(false);
		b.setOption(BerechnungsOptionen.FASTESTWAY);
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(str), b);
		try {
			opb = dj.run(new Long(1), new Long(4));
			assertTrue(true);
			assertEquals(20, opb.getStreckenInklGewichtung(), 0);
			assertEquals("A, B, D", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
