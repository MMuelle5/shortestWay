package com.mima.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	
	
	public static StrasseBo getBo() {
		return bo;
	}

	public static void init(StrasseBo bo) {
		Dijkstra.bo = bo;
	}

	/*
	 * Startpunkt gegeben
	 * aktPkt = Startpunkt
	 * while(aktPkt != endPkt)
	 * 		alleVerbindungen holen
	 * 		akt pkt als "vorbei gekommen" markieren
	 * 		neu erhaltene Pkte mit distanz abfüllen
	 * 		neue Pkt bereits abgefüllt?
	 * 		ja:
	 * 			kleiner?
	 *			ja:
	 *				pkt als neuen aktPkt nehmen
	 *			nein:
	 *				kleinster pkt als aktPkt nehmen
	 *		nein:
	 *			kleinster pkt als aktPkt nehmen
	 * 
	 */
	public static OrtsPunktBean run(Long startPunktId, Long endPunktId) throws BoException {
		
		HashMap<Long, OrtsPunktBean> punkte = new HashMap<Long, OrtsPunktBean>();
		OrtsPunktBean aktPktBean = new OrtsPunktBean();
		aktPktBean.setPunkteBeschreibung("A");
		aktPktBean.setPunkteHistory(new ArrayList<OrtsPunktBean>());
		aktPktBean.getPunkteHistory().add(aktPktBean);
		aktPktBean.setKontrolliert(true);
		aktPktBean.setPunkteId(startPunktId);
		punkte.put(aktPktBean.getPunkteId(), aktPktBean);
		List<Strasse> nextList = new ArrayList<Strasse>();
		OrtsPunktBean nextPkt = new OrtsPunktBean();
		OrtsPunktBean nextShortestPkt = new OrtsPunktBean();
		Long aktPkt = startPunktId;
		boolean isInHistory = false;
		
		while(aktPkt != endPunktId && !aktPkt.equals(endPunktId)) {

			 nextList = bo.findStreetsByStartPoint(aktPkt);
			 
			 nextShortestPkt = new OrtsPunktBean();
			 nextShortestPkt.setDistanz(99999999);
			 
			 for(Strasse str : nextList) {
				 double totalDistanz = aktPktBean.getDistanz() +str.getDistanz();
				 
				 nextPkt = punkte.get(str.getEndPunktId());
				 if(nextPkt != null) {
					 isInHistory = false;
//					 for(OrtsPunktBean history :aktPktBean.getPunkteHistory()) {
//						 if(history.getPunkteId() == nextPkt.getPunkteId()) {
//							 isInHistory = true;
//							 break;
//						 }
//					 }
					 if(totalDistanz > nextPkt.getDistanz() && !nextPkt.isKontrolliert()) { //TODO bock liegt hier irgendwo begraben...
//						 nextPkt.setDistanz(totalDistanz);
//						 nextPkt.setPunkteHistory(aktPktBean.getPunkteHistory());
//						 punkte.get(aktPkt).setKontrolliert(false);
						 punkte.remove(aktPkt);
						 nextShortestPkt = nextPkt;
						 break;
					 }
					 else {
						 continue;
					 }
				 }
				 else {
					 nextPkt = new OrtsPunktBean();
					 nextPkt.setDistanz(totalDistanz);
					 nextPkt.setPunkteBeschreibung(str.getEndPunktName());
					 nextPkt.setPunkteId(str.getEndPunktId());
					 nextPkt.setPunkteHistory(aktPktBean.getPunkteHistory());
					 nextPkt.getPunkteHistory().add(nextPkt);
					 punkte.put(nextPkt.getPunkteId(), nextPkt);
				 }
				 if(nextPkt.getDistanz() < nextShortestPkt.getDistanz()) {
					 nextShortestPkt = nextPkt;
				 }
			 }
			 aktPkt = nextShortestPkt.getPunkteId();
			 aktPktBean = nextShortestPkt;
			 aktPktBean.setKontrolliert(true);
			 punkte.get(aktPkt).setKontrolliert(true);
			 System.out.println(aktPktBean.getPunkteBeschreibung()+": "+aktPktBean.getDistanz());
		}
		
		return aktPktBean;
	}
}


			