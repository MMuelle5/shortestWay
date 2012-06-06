package com.mima.db.mock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mima.db.dao.PointDao;
import com.mima.db.dao.StrasseDao;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

public class StrassenMock03 implements StrasseDao, PointDao{	
	
	@Override
	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId) {
				
		List<StrasseDTO> ret = new ArrayList<StrasseDTO>();
		
		if(startPunktId ==1){
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(3));
			s.setDistanz(Long.valueOf(9));
			ret.add(s);
			
		}
		else if(startPunktId==2) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(4));
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
		}
		else if(startPunktId==3) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(1));
			s.setDistanz(Long.valueOf(9));
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
		}
		else {

			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(2));
			s.setDistanz(Long.valueOf(10));
			ret.add(s);			
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
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
		
		s = new OrtDTO();
		s.setPointId((long) 3);
		s.setDescription("C");
		sl.add(s);
		
		s = new OrtDTO();
		s.setPointId((long) 4);
		s.setDescription("D");
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

	
}
