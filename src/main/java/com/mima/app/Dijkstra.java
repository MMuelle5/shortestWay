package com.mima.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mima.app.bean.OrtsPunktBean;
import com.mima.db.bo.StrasseBo;
import com.mima.db.exception.BoException;
import com.mima.db.model.Strasse;

/**
 * 
 * @author MARIUS
 * 
 */
public class Dijkstra {

	private static StrasseBo bo;
	private static HashMap<Long, OrtsPunktBean> punkte = new HashMap<Long, OrtsPunktBean>();

	public static StrasseBo getBo() {
		return bo;
	}

	public static void init(StrasseBo bo) {
		Dijkstra.bo = bo;
	}

	/*
	 * Startpunkt gegeben aktPkt = Startpunkt while(aktPkt != endPkt)
	 * alleVerbindungen holen akt pkt als "vorbei gekommen" markieren neu
	 * erhaltene Pkte mit distanz abfüllen neue Pkt bereits abgefüllt? ja:
	 * kleiner? ja: pkt als neuen aktPkt nehmen nein: kleinster pkt als aktPkt
	 * nehmen nein: kleinster pkt als aktPkt nehmen
	 */
	public static OrtsPunktBean run(Long startPunktId, Long endPunktId)
			throws BoException {

		// init 1. Bean
		Strasse start = bo.findStartPointById(startPunktId);
		
		OrtsPunktBean aktPktBean = new OrtsPunktBean();
		aktPktBean.setPunkteBeschreibung(start.getStartPunktName());
		aktPktBean.setKontrolliert(true);
		aktPktBean.setPunkteId(startPunktId);
		punkte.put(aktPktBean.getPunkteId(), aktPktBean);

		List<Strasse> nextList = new ArrayList<Strasse>();
		Long aktPkt = startPunktId;

		while (aktPkt != endPunktId && !aktPkt.equals(endPunktId)) {

			nextList = bo.findStreetsByStartPoint(aktPkt);

			aktPktBean = getNextShortestPkt(nextList, aktPktBean);
			aktPkt = aktPktBean.getPunkteId();
			aktPktBean.setKontrolliert(true);
			punkte.get(aktPkt).setKontrolliert(true);
		}

		return aktPktBean;
	}

	/**
	 * Sucht den naechsten kuerzesten Pfad aus der nextList
	 * @param nextList
	 * @param aktPktBean
	 * @return
	 */
	private static OrtsPunktBean getNextShortestPkt(List<Strasse> nextList, OrtsPunktBean aktPktBean) {
		OrtsPunktBean nextPkt = new OrtsPunktBean();
		OrtsPunktBean nextShortestPkt = new OrtsPunktBean();
		nextShortestPkt = new OrtsPunktBean();
		nextShortestPkt.setDistanz(99999999);
		for (Strasse str : nextList) {
			double totalDistanz = aktPktBean.getDistanz() + str.getDistanz();

			nextPkt = punkte.get(str.getEndPunktId());
			if (nextPkt != null) {
				if (nextPkt.isKontrolliert()) {
					continue;
				} else if (totalDistanz < nextPkt.getDistanz()) {
					nextPkt.setDistanz(totalDistanz);
					nextPkt.setPrevPunkt(aktPktBean);
				}
			} else {
				nextPkt = new OrtsPunktBean();
				nextPkt.setDistanz(totalDistanz);
				nextPkt.setPunkteBeschreibung(str.getEndPunktName());
				nextPkt.setPunkteId(str.getEndPunktId());
				nextPkt.setPrevPunkt(aktPktBean);
				punkte.put(nextPkt.getPunkteId(), nextPkt);
			}
			if (nextPkt.getDistanz() < nextShortestPkt.getDistanz()) {
				nextShortestPkt = nextPkt;
			}
		}
		return nextShortestPkt;
	}
}
