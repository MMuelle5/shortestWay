package com.mima.app;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mima.db.bo.impl.StrasseBoImpl;
import com.mima.db.dao.StrasseDao;
import com.mima.db.mock.StrassenMock;


public class DJTest {

	@Before
	public void init() {
		StrasseDao str = new StrassenMock();
		Dijkstra.init(new StrasseBoImpl(str));
	}
	
	@Test
	public void testDJ() {
		OrtsPunktBean opb;
		try {
			opb = Dijkstra.run(new Long(1), new Long(5));
			assertTrue(true);
			System.out.println(opb.getDistanz());
			for(OrtsPunktBean o :opb.getPunkteHistory()) {
				System.out.println(o.getPunkteBeschreibung()+" "+o.getDistanz());
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		System.out.println("wusch");
	}
}
