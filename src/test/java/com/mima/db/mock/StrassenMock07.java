package com.mima.db.mock;

import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.StrasseDao;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.Strasse;

public class StrassenMock07 implements StrasseDao{	
	
	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktId) {
		
		
		
		List<Strasse> ret = new ArrayList<Strasse>();
		
		if(startPunktId ==1){
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
			s.setDistanz(Long.valueOf(8));
			s.setSpeed(120);
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(3));
			s.setDistanz(Long.valueOf(2));
			s.setSpeed(50);
			ret.add(s);
			
			
		}
		else if(startPunktId==2) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
			s.setDistanz(Long.valueOf(8));
			s.setSpeed(120);
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(3));
			s.setDistanz(Long.valueOf(8));
			s.setSpeed(50);
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(7));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(80);
			ret.add(s);
			
		}
		else if(startPunktId==3) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(1));
			s.setDistanz(Long.valueOf(2));
			s.setSpeed(50);
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(2));
			s.setDistanz(Long.valueOf(8));
			s.setSpeed(50);
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
			s.setDistanz(Long.valueOf(4));
			s.setSpeed(30);
			ret.add(s);
			
		}

		else if(startPunktId==4) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
			s.setDistanz(Long.valueOf(4));
			s.setSpeed(50);
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(5));
			s.setDistanz(Long.valueOf(6));
			s.setSpeed(60);
			ret.add(s);
			
		}		

		else if(startPunktId==5) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(4));
			s.setDistanz(Long.valueOf(6));
			s.setSpeed(50);
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(6));
			s.setDistanz(Long.valueOf(7));
			s.setSpeed(60);
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(8));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(50);
			ret.add(s);
			
		}
		
		else if(startPunktId==6) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(6));
			s.setEndPunktId(Long.valueOf(5));
			s.setDistanz(Long.valueOf(7));
			s.setSpeed(50);
			ret.add(s);
						
		}
		
		else if(startPunktId==7) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(7));
			s.setEndPunktId(Long.valueOf(2));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(50);
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(7));
			s.setEndPunktId(Long.valueOf(8));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(60);
			ret.add(s);
			
		}
		
		else {

			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(8));
			s.setEndPunktId(Long.valueOf(5));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(80);
			ret.add(s);			
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(8));
			s.setEndPunktId(Long.valueOf(7));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(80);
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

		s = new OrtDTO();
		s.setPointId((long) 7);
		s.setDescription("G");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 8);
		s.setDescription("H");
		sl.add(s);
		
		return sl;
	}

	@Override
	public OrtDTO findPointByAxis(Long punktX, Long punktY) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
