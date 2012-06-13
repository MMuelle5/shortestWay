package com.mima.db.mock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.PointDao;
import com.mima.db.dao.StrasseDao;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

public class StrassenMock07 implements StrasseDao, PointDao{	
	
	@Override
	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId, boolean b) {
		
		
		
		List<StrasseDTO> ret = new ArrayList<StrasseDTO>();
		
		if(startPunktId ==1){
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
			s.setDistanz(Long.valueOf(8));
			s.setSpeed(120);
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(3));
			s.setDistanz(Long.valueOf(2));
			s.setSpeed(50);
			ret.add(s);
			
			
		}
		else if(startPunktId==2) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
			s.setDistanz(Long.valueOf(8));
			s.setSpeed(120);
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(3));
			s.setDistanz(Long.valueOf(8));
			s.setSpeed(50);
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(7));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(80);
			ret.add(s);
			
		}
		else if(startPunktId==3) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(1));
			s.setDistanz(Long.valueOf(2));
			s.setSpeed(50);
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(2));
			s.setDistanz(Long.valueOf(8));
			s.setSpeed(50);
			ret.add(s);

			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
			s.setDistanz(Long.valueOf(4));
			s.setSpeed(30);
			ret.add(s);
			
		}

		else if(startPunktId==4) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
			s.setDistanz(Long.valueOf(4));
			s.setSpeed(50);
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(5));
			s.setDistanz(Long.valueOf(6));
			s.setSpeed(60);
			ret.add(s);
			
		}		

		else if(startPunktId==5) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(4));
			s.setDistanz(Long.valueOf(6));
			s.setSpeed(50);
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(6));
			s.setDistanz(Long.valueOf(7));
			s.setSpeed(60);
			ret.add(s);

			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(8));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(50);
			ret.add(s);
			
		}
		
		else if(startPunktId==6) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(6));
			s.setEndPunktId(Long.valueOf(5));
			s.setDistanz(Long.valueOf(7));
			s.setSpeed(50);
			ret.add(s);
						
		}
		
		else if(startPunktId==7) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(7));
			s.setEndPunktId(Long.valueOf(2));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(50);
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(7));
			s.setEndPunktId(Long.valueOf(8));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(60);
			ret.add(s);
			
		}
		
		else {

			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(8));
			s.setEndPunktId(Long.valueOf(5));
			s.setDistanz(Long.valueOf(1));
			s.setSpeed(80);
			ret.add(s);			
			
			s= new StrasseDTO();
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
	public OrtDTO findPointByAxis(int punktX, int punktY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrtDTO createPoint(OrtDTO dto) throws SQLException {

		return null;
	}

	@Override
	public void deletePoint(OrtDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StrasseComponentDTO> findAllStreetsToDisplay()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createStrasse(StrasseDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrasse(StrasseDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStrasse(StrasseDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long findPointIdByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
