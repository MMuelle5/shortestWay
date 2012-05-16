package com.mima.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
<<<<<<< HEAD:src/test/java/com/mima/app/DJTest01.java
import com.mima.db.mock.StrassenMock01;


public class DJTest01 {

	@Before
	public void init() {
		StrasseDao str = new StrassenMock01();
		Dijkstra.init(new StrasseBoImpl(str));
	}
=======
import com.mima.db.mock.StrassenMock;


public class DJTest {
>>>>>>> 4e2066d466ff4288ebfdce7547ad4612148a99cf:src/test/java/com/mima/app/DJTest.java
	
	@Test
	public void testDJ01() {
		OrtsPunktBean opb;
		StrasseDao str = new StrassenMock();
		BerechnungsOptionen b = new BerechnungsOptionen();
		b.setMautAllowed(false);
		b.setOption(BerechnungsOptionen.SHORTESTWAY);
		Dijkstra dj = new Dijkstra(new StrasseBoImpl(str), b);
		try {
			opb = dj.run(new Long(1), new Long(5));
			assertTrue(true);
			assertEquals(9, opb.getStreckenInklGewichtung(), 0);
			assertEquals("A, C, D, E", opb.getHistory());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
