package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.PointBoImpl;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock06;


public class DJTest06 {
	
	@Test
	public void testDJ06() {
		OrtsPunktBean opb;
		StrasseDao str = new StrassenMock06();
		BerechnungsOptionen b = new BerechnungsOptionen();
		b.setMautAllowed(false);
		b.setOption(BerechnungsOptionen.FASTESTWAY);
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(str), new PointBoImpl(new StrassenMock06()), b);
		try {
			opb = dj.run(new Long(1), new Long(3));
			assertTrue(true);
			assertEquals(13, opb.getDistanz(), 0);
			assertEquals("A, B, C", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
