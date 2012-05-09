package com.mima.db.mock;

import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.StrasseDao;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.Strasse;

public class StrassenMock2 implements StrasseDao{	
	
	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktId) {
		
		
		
		List<Strasse> ret = new ArrayList<Strasse>();
		
		if(startPunktId ==1){
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("s");
//			s.setEndPunktName("v1");
			s.setDistanz(Long.valueOf(11));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("s");
//			s.setEndPunktName("v2");
			s.setDistanz(Long.valueOf(9));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("s");
//			s.setEndPunktName("v3");
			s.setDistanz(Long.valueOf(14));
			ret.add(s);

		}
		else if(startPunktId==2) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
//			s.setStartPunktName("v1");
//			s.setEndPunktName("s");
			s.setDistanz(Long.valueOf(11));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("v1");
//			s.setEndPunktName("v3");
			s.setDistanz(Long.valueOf(5));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(5));
//			s.setStartPunktName("v1");
//			s.setEndPunktName("v4");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
		}
		else if(startPunktId==3) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(1));
//			s.setStartPunktName("v2");
//			s.setEndPunktName("s");
			s.setDistanz(Long.valueOf(9));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("v2");
//			s.setEndPunktName("v3");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(6));
//			s.setStartPunktName("v2");
//			s.setEndPunktName("v5");
			s.setDistanz(Long.valueOf(9));
			ret.add(s);
			
		}
		else if(startPunktId==4) {

			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(1));
//			s.setStartPunktName("v3");
//			s.setEndPunktName("s");
			s.setDistanz(Long.valueOf(14));
			ret.add(s);			
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("v3");
//			s.setEndPunktName("v1");
			s.setDistanz(Long.valueOf(5));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("v3");
//			s.setEndPunktName("v2");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(5));
//			s.setStartPunktName("v3");
//			s.setEndPunktName("v4");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);
		
		}
		else if(startPunktId==5) {

			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("v4");
//			s.setEndPunktName("v1");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);			
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("v4");
//			s.setEndPunktName("v3");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(6));
//			s.setStartPunktName("v4");
//			s.setEndPunktName("v5");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
		}
		
		
		else {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(6));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("v5");
//			s.setEndPunktName("v2");
			s.setDistanz(Long.valueOf(9));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(6));
			s.setEndPunktId(Long.valueOf(5));
//			s.setStartPunktName("v5");
//			s.setEndPunktName("v4");
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
		s.setDescription("s");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 2);
		s.setDescription("v1");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 3);
		s.setDescription("v2");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 4);
		s.setDescription("v3");
		sl.add(s);

		s = new OrtDTO();
		s.setPointId((long) 5);
		s.setDescription("v4");
		sl.add(s);

		s = new OrtDTO();
		s.setPointId((long) 6);
		s.setDescription("v5");
		sl.add(s);

		return sl;
	}

	@Override
	public OrtDTO findPointByAxis(Long punktX, Long punktY) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
