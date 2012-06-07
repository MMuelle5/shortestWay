package com.mima.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.PointBo;
import com.mima.db.bo.StrasseBo;
import com.mima.db.exception.BoException;
import com.mima.db.model.OrtDTO;
import com.mima.db.model.StrasseDTO;

/**
 * Dijkstra-Algorithmus
 *
 * @author i10b@zhaw: M. MŸller / M. Ott
 *
 */
public class Dijkstra {

	private static final double DEFAULTDISTANZ = 99999999;
	
	private StrasseBo bo;
	private PointBo pbo;
	private HashMap<Long, OrtsPunktBean> punkte = new HashMap<Long, OrtsPunktBean>();
	private BerechnungsOptionen berechnung;
	
	public Dijkstra(StrasseBo bo, PointBo pbo, BerechnungsOptionen berechnung) {
		super();
		this.bo = bo;
		this.pbo = pbo;
		this.berechnung = berechnung;
	}

	public OrtsPunktBean run(int startPunktX, int startPunktY, int endPunktX, int endPunktY) throws BoException {
		OrtDTO start = pbo.findPointByAxis(startPunktX, startPunktY);
		OrtDTO end = pbo.findPointByAxis(endPunktX, endPunktY);
		
		return run(start.getPointId(), end.getPointId());
	}
	
	/**
	 * 
	 * Startpunkt gegeben aktPkt = Startpunkt while(aktPkt != endPkt)
	 * alleVerbindungen holen akt pkt als "vorbei gekommen" markieren neu
	 * erhaltene Pkte mit distanz abfüllen neue Pkt bereits abgefüllt? ja:
	 * kleiner? ja: pkt als neuen aktPkt nehmen nein: kleinster pkt als aktPkt
	 * nehmen nein: kleinster pkt als aktPkt nehmen
	 * @param startPunktId
	 * @param endPunktId
	 * @return
	 * @throws BoException
	 */
	public OrtsPunktBean run(Long startPunktId, Long endPunktId) throws BoException {

		// init 1. Bean
		List<OrtDTO> allePunkte = pbo.findAllPointIds();

		OrtsPunktBean pktBean;
		OrtDTO str;
		for(int i = allePunkte.size()-1; i >=0; i--) {
			str = allePunkte.get(i);
			pktBean = new OrtsPunktBean();
			pktBean.setPunkteId(str.getPointId());
			pktBean.setPunkteBeschreibung(str.getDescription());
			pktBean.setStreckenInklGewichtung(DEFAULTDISTANZ);
			pktBean.setPointX(str.getPointX());
			pktBean.setPointY(str.getPointY());
			
			if(str.getPointId() == startPunktId || str.getPointId().equals(startPunktId)) {
				pktBean.setStreckenInklGewichtung(0);
			}
			punkte.put(pktBean.getPunkteId(), pktBean);
		}

		List<StrasseDTO> nextList = new ArrayList<StrasseDTO>();
		OrtsPunktBean aktPktBean = new OrtsPunktBean();
		aktPktBean.setStreckenInklGewichtung(DEFAULTDISTANZ);
		Long aktPkt;
		OrtsPunktBean pkt;
		OrtsPunktBean shortest = new OrtsPunktBean();
		shortest.setStreckenInklGewichtung(DEFAULTDISTANZ);
//		boolean hasNewPoint = false;

		while(allePunkte.size() != 0) {

			for(int i = allePunkte.size()-1; i >=0; i--) {
				str = allePunkte.get(i);
				pkt = punkte.get(str.getPointId());
				if(pkt.isKontrolliert()) {
					allePunkte.remove(i);
				} else if(aktPktBean.getStreckenInklGewichtung() > pkt.getStreckenInklGewichtung()){
					aktPktBean = pkt;
//					hasNewPoint = true;
					allePunkte.remove(i);
				}
			}
//			if(!hasNewPoint) {
//				return shortest;
//			}
//			hasNewPoint = false;
			aktPkt = aktPktBean.getPunkteId();
			aktPktBean.setKontrolliert(true);
			punkte.get(aktPkt).setKontrolliert(true);
				
//			while (aktPkt != endPunktId && !aktPkt.equals(endPunktId)) {
	
				nextList = bo.findStreetsByStartPoint(aktPkt);
	
				aktPktBean = getNextShortestPkt(nextList, aktPktBean);
				if(aktPktBean.getStreckenInklGewichtung() != DEFAULTDISTANZ) {
					aktPkt = aktPktBean.getPunkteId();
//					aktPktBean.setKontrolliert(true);
//					punkte.get(aktPkt).setKontrolliert(true);
				}
				else { //sackgasse
					break;
				}
//			}
			if(shortest.getStreckenInklGewichtung() > aktPktBean.getStreckenInklGewichtung() && (aktPkt == endPunktId || aktPkt.equals(endPunktId))) {
				shortest = aktPktBean;
			}
		}

//		Testfall-Ausgabe
//		for(int i = 1; i <= 5; i++) {
//
//			System.out.println(punkte.get(new Long(i)).getPunkteBeschreibung());
//			System.out.println(punkte.get(new Long(i)).getHistory());
//		}
		
		return shortest;
	}

	/**
	 * Sucht den naechsten kuerzesten Pfad aus der nextList
	 * @param nextList
	 * @param aktPktBean
	 * @return
	 */
	private OrtsPunktBean getNextShortestPkt(List<StrasseDTO> nextList, OrtsPunktBean aktPktBean) {
		OrtsPunktBean nextPkt = new OrtsPunktBean();
		OrtsPunktBean nextShortestPkt = new OrtsPunktBean();
		nextShortestPkt = new OrtsPunktBean();
		nextShortestPkt.setStreckenInklGewichtung(DEFAULTDISTANZ);
		for (StrasseDTO str : nextList) {
//			double totalDistanz = aktPktBean.getStreckenInklGewichtung() + str.getDistanz();
			double totalDistanz = berechnung.calcDistanzInklGew(aktPktBean.getStreckenInklGewichtung(),str);

			nextPkt = punkte.get(str.getEndPunktId());
			if (nextPkt.getPunkteId() != null) {
				if (nextPkt.isKontrolliert()) {
					continue;
				} else if (totalDistanz < nextPkt.getStreckenInklGewichtung()) {
					nextPkt.setStreckenInklGewichtung(totalDistanz);
					nextPkt.setDistanz(aktPktBean.getDistanz()+str.getDistanz());
					nextPkt.setPrevPunkt(aktPktBean);
				}
			} else {
//				nextPkt = new OrtsPunktBean();
				nextPkt.setStreckenInklGewichtung(totalDistanz);
				nextPkt.setDistanz(aktPktBean.getDistanz()+str.getDistanz());
//				nextPkt.setPunkteBeschreibung(str.getEndPunktName());
//				nextPkt.setPunkteId(str.getEndPunktId());
				nextPkt.setPrevPunkt(aktPktBean);
//				punkte.put(nextPkt.getPunkteId(), nextPkt);
			}
			if (nextPkt.getStreckenInklGewichtung() < nextShortestPkt.getStreckenInklGewichtung()) {
				nextShortestPkt = nextPkt;
			}
		}
		return nextShortestPkt;
	}
}
