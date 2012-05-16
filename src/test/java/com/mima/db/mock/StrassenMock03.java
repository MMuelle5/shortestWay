package com.mima.db.mock;

import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.StrasseDao;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.Strasse;

public class StrassenMock03 implements StrasseDao{	
	
	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktId) {
				
		List<Strasse> ret = new ArrayList<Strasse>();

		// einfacher Testfall mit unterschiedlichen Weggeschwindigkeiten (A, B, gleich lange Strecken)
		
		if(startPunktId ==1){
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
			s.setStartPunktName("A");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
			s.setStartPunktName("A");
			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
		}
		else if(startPunktId==2) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
			s.setStartPunktName("B");
			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
			s.setStartPunktName("B");
			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(10));
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
		
		return sl;
	}

	@Override
	public Strasse findPointByAxis(Long punktX, Long punktY) {
		// TODO Auto-generated method stub
		return null;
	}

}
