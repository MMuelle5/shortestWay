package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.PointBoImpl;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock02;


public class DJTest02 {
	
	@Test
	public void testDJ02() {
		OrtsPunktBean opb;
		StrasseDao str = new StrassenMock02();
		BerechnungsOptionen b = new BerechnungsOptionen();
		b.setMautAllowed(false);
		b.setOption(BerechnungsOptionen.SHORTESTWAY);
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(str), new PointBoImpl(new StrassenMock02()), b);
		try {
			opb = dj.run(new Long(1), new Long(6));
			assertTrue(true);
			assertEquals(16, opb.getStreckenInklGewichtung(), 0);
			assertEquals("s, v2, v3, v4, v5", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
