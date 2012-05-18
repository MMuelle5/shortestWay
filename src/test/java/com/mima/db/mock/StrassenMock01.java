package com.mima.db.mock;

import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.StrasseDao;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.Strasse;

public class StrassenMock01 implements StrasseDao{	
	
	@Override
	public List<Strasse> findStreetsByStartPoint(Long startPunktId) {
		
		
		
		List<Strasse> ret = new ArrayList<Strasse>();
		
		if(startPunktId ==1){
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("A");
//			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("A");
//			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
		}
		else if(startPunktId==2) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
//			s.setStartPunktName("B");
//			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("B");
//			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("B");
//			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(5));
//			s.setStartPunktName("B");
//			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
		}
		else if(startPunktId==3) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(1));
//			s.setStartPunktName("C");
//			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("C");
//			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("C");
//			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);
		}
		else if(startPunktId==4) {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("D");
//			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("D");
//			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);

			s= new Strasse();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(5));
//			s.setStartPunktName("D");
//			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
		}
		else {
			Strasse s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("E");
//			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
			s= new Strasse();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("E");
//			s.setEndPunktName("D");
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
		s.setPointX(20);
		s.setPointY(20);
		s.setDescription("A");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 2);
		s.setPointX(20);
		s.setPointY(10);
		s.setDescription("B");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 3);
		s.setPointX(40);
		s.setPointY(20);
		s.setDescription("C");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 4);
		s.setPointX(80);
		s.setPointY(10);
		s.setDescription("D");
		sl.add(s);

		s = new OrtDTO();
		s.setPointId((long) 5);
		s.setPointX(90);
		s.setPointY(90);
		s.setDescription("E");
		sl.add(s);
		
		return sl;
	}

	@Override
	public OrtDTO findPointByAxis(Long punktX, Long punktY) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
