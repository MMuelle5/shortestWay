package com.mima.db.mock;

import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.StrasseDao;
import com.mima.db.model.Strasse;

public class StrassenMock implements StrasseDao{	
	
	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktId) {
		
		
		
		List<Strasse> ret = new ArrayList<Strasse>();
		
		if(startPunktId.equals(1)){
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
			s.setEndPunktName("A");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(3));
			s.setEndPunktName("A");
			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
		}
		else if(startPunktId.equals(2)) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
			s.setEndPunktName("B");
			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(3));
			s.setEndPunktName("B");
			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(4));
			s.setEndPunktName("B");
			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(5));
			s.setEndPunktName("B");
			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
		}
		else if(startPunktId.equals(3)) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(1));
			s.setEndPunktName("C");
			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(2));
			s.setEndPunktName("C");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
			s.setEndPunktName("C");
			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);
		}
		else if(startPunktId.equals(4)) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
			s.setEndPunktName("D");
			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(2));
			s.setEndPunktName("D");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(5));
			s.setEndPunktName("D");
			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
		}
		else {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(2));
			s.setEndPunktName("E");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(4));
			s.setEndPunktName("E");
			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);

		}
		
		return ret;
	}

	
}
