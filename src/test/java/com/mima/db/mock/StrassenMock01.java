package com.mima.db.mock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mima.db.dao.PointDao;
import com.mima.db.dao.StrasseDao;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseComponentDTO;
import com.mima.db.model.StrasseDTO;

public class StrassenMock01 implements StrasseDao, PointDao{	
	
	@Override
	public List<StrasseDTO> findStreetsByStartPoint(Long startPunktId, boolean b) {
		
		
		
		List<StrasseDTO> ret = new ArrayList<StrasseDTO>();
		
		if(startPunktId ==1){
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("A");
//			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(1));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("A");
//			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
		}
		else if(startPunktId==2) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(1));
//			s.setStartPunktName("B");
//			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("B");
//			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("B");
//			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(2));
			s.setEndPunktId(Long.valueOf(5));
//			s.setStartPunktName("B");
//			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
		}
		else if(startPunktId==3) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(1));
//			s.setStartPunktName("C");
//			s.setEndPunktName("A");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("C");
//			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(2));
			ret.add(s);

			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(3));
			s.setEndPunktId(Long.valueOf(4));
//			s.setStartPunktName("C");
//			s.setEndPunktName("D");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);
		}
		else if(startPunktId==4) {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("D");
//			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
			
			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(3));
//			s.setStartPunktName("D");
//			s.setEndPunktName("C");
			s.setDistanz(Long.valueOf(1));
			ret.add(s);

			s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(4));
			s.setEndPunktId(Long.valueOf(5));
//			s.setStartPunktName("D");
//			s.setEndPunktName("E");
			s.setDistanz(Long.valueOf(4));
			ret.add(s);
		}
		else {
			StrasseDTO s= new StrasseDTO();
			s.setStartPunktId(Long.valueOf(5));
			s.setEndPunktId(Long.valueOf(2));
//			s.setStartPunktName("E");
//			s.setEndPunktName("B");
			s.setDistanz(Long.valueOf(10));
			ret.add(s);
			
			s= new StrasseDTO();
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

	@Override
	public Map<Integer, StrasseComponentDTO> deleteStreetsByPointId(Long pointId)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
