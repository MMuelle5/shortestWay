package com.mima.db.mock;

import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.StrasseDao;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.Strasse;

public class StrassenMock implements StrasseDao{	
	
	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktId) {
		
		
		
		List<Strasse> ret = new ArrayList<Strasse>();
		
		if(startPunktId ==1){
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
			s.setStartPunktName("A");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(11));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(3));
			s.setStartPunktName("A");
			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(14));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(4));
			s.setStartPunktName("A");
			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(9));
			ret.add(s);

		}
		else if(startPunktId==2) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
			s.setStartPunktName("B");
			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(3));
			s.setStartPunktName("B");
			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(5));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(4));
			s.setStartPunktName("B");
			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
		}
		else if(startPunktId==3) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(1));
			s.setStartPunktName("C");
			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(14));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(2));
			s.setStartPunktName("C");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(5));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
			s.setStartPunktName("C");
			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
			s.setStartPunktName("C");
			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);
			
		}
		else if(startPunktId==4) {

			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
			s.setStartPunktName("D");
			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(9));
			ret.add(s);			
			
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
			s.setStartPunktName("D");
			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(2));
			s.setStartPunktName("D");
			s.setEndPunktName("F");
			s.setDistanz(Long.valueOf(9));
			ret.add(s);
		}
		else if(startPunktId==5) {

			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
			s.setStartPunktName("E");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);			
			
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
			s.setStartPunktName("E");
			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(2));
			s.setStartPunktName("E");
			s.setEndPunktName("F");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
		}
		
		
		else {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(2));
			s.setStartPunktName("F");
			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(9));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(4));
			s.setStartPunktName("F");
			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);

		}
		
		return ret;
	}

	@Override
	public List<OrtDTO> findAllPoints() {
		List<OrtDTO> sl = new ArrayList<OrtDTO>();
		OrtDTO s = new OrtDTO();
		s.setPointId((long) 1);
		s.setDescription("A");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 2);
		s.setDescription("B");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 3);
		s.setDescription("C");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 4);
		s.setDescription("D");
		sl.add(s);

		s = new OrtDTO();
		s.setPointId((long) 5);
		s.setDescription("E");
		sl.add(s);

		s = new OrtDTO();
		s.setPointId((long) 6);
		s.setDescription("F");
		sl.add(s);

		return sl;
	}

	@Override
	public Strasse findPointByAxis(Long punktX, Long punktY) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
