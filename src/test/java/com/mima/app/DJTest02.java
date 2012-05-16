package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock02;


<<<<<<< HEAD:src/test/java/com/mima/app/DJTest02.java
public class DJTest02 {

	@Before
	public void init() {
		StrasseDao str = new StrassenMock02();
		Dijkstra.init(new StrasseBoImpl(str));
	}
=======
public class DJTest2 {
>>>>>>> 4e2066d466ff4288ebfdce7547ad4612148a99cf:src/test/java/com/mima/app/DJTest2.java
	
	@Test
	public void testDJ02() {
		OrtsPunktBean opb;
		StrasseDao str = new StrassenMock2();
		BerechnungsOptionen b = new BerechnungsOptionen();
		b.setMautAllowed(false);
		b.setOption(BerechnungsOptionen.SHORTESTWAY);
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(str), b);
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
