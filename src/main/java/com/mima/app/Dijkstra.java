package com.mima.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mima.app.bean.BerechnungsOptionen;
import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.PointBo;
import com.mima.db.bo.StrasseBo;
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

	public OrtsPunktBean run(int startPunktX, int startPunktY, int endPunktX, int endPunktY) throws Exception {
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
	 * @throws Exception 
	 */
	public OrtsPunktBean run(Long startPunktId, Long endPunktId) throws Exception {

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
		Long aktPkt = null;
		OrtsPunktBean pkt;
		OrtsPunktBean shortest = new OrtsPunktBean();
		shortest.setStreckenInklGewichtung(DEFAULTDISTANZ);

		while(aktPkt != endPunktId) {

			aktPktBean = new OrtsPunktBean();
			aktPktBean.setStreckenInklGewichtung(DEFAULTDISTANZ);
			for(int i = allePunkte.size()-1; i >=0; i--) {
				str = allePunkte.get(i);
				pkt = punkte.get(str.getPointId());
				if(pkt.isKontrolliert()) {
					allePunkte.remove(i);
				} else if(aktPktBean.getStreckenInklGewichtung() > pkt.getStreckenInklGewichtung()){
					aktPktBean = pkt;
				}
			}

			aktPkt = aktPktBean.getPunkteId();
			if(aktPkt != null) {
				punkte.get(aktPkt).setKontrolliert(true);
				if(aktPkt == endPunktId) {
					return aktPktBean;
				}
			}
			else {
				throw new Exception(); // Punkt wird nicht erreicht
			}
			aktPktBean.setKontrolliert(true);
				
			nextList = bo.findStreetsByStartPoint(aktPkt);

			aktPktBean = getNextShortestPkt(nextList, aktPktBean);

			if(shortest.getStreckenInklGewichtung() > aktPktBean.getStreckenInklGewichtung() && (aktPkt == endPunktId || aktPkt.equals(endPunktId))) {
				shortest = aktPktBean;
			}
		}
		
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

			double totalDistanz = berechnung.calcDistanzInklGew(aktPktBean.getStreckenInklGewichtung(),str);

			nextPkt = punkte.get(str.getEndPunktId());
			if (nextPkt.isKontrolliert()) {
				continue;
			}
			else if (nextPkt.getPrevPunkt() != null && totalDistanz < nextPkt.getStreckenInklGewichtung()) {
					nextPkt.setStreckenInklGewichtung(totalDistanz);
					nextPkt.setDistanz(aktPktBean.getDistanz()+str.getDistanz());
					nextPkt.setPrevPunkt(aktPktBean);
			} else {
				nextPkt.setStreckenInklGewichtung(totalDistanz);
				nextPkt.setDistanz(aktPktBean.getDistanz()+str.getDistanz());
				nextPkt.setPrevPunkt(aktPktBean);
			}
			if (nextPkt.getStreckenInklGewichtung() < nextShortestPkt.getStreckenInklGewichtung()) {
				nextShortestPkt = nextPkt;
			}
		}
		return nextShortestPkt;
	}
}
