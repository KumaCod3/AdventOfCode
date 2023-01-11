package aOc22;

import java.util.ArrayList;
import program.Read;

public class Day16_2022 {
	// piu percorsi, piu strade, piu valve
	static ArrayList<Percorsi> strade=new ArrayList<Percorsi>();
	static ArrayList<Strada> percorso=new ArrayList<Strada>();
	
	public static long calculate1(String s) {
		int fin=0;
		ArrayList<String[]> list=Read.elep(s);
		int maxMax=0;
		ArrayList<Strada> temp=new ArrayList<Strada>();
		ArrayList<Strada> win=new ArrayList<Strada>();
		int aper=list.size();

		for (String[] a:list) {
			Valve v=new Valve(a);
			if (v.aperto) {
				aper=aper-1;
			}
			Valve.agg(v);
		}
		Strada st=new Strada(new Valve(Valve.coll.get("AA")),aper);
		percorso.add(st);
		
		while (percorso.size()>0) {
			for (Strada ss:percorso) {
				boolean tr=false;
				for (String nx:ss.strada.get(ss.now).ele) {
					Strada te=new Strada(ss);
					if (te.vai(nx)) {
						tr=true;
						temp.add(te);
					}
				}
				if (ss.strada.get(ss.now).aperto==false) {
					tr=true;
					ss.strada.get(ss.now).open();
					ss.valLeft=ss.valLeft-1;
					ss.passa();
					ss.presPm=ss.presPm+ss.strada.get(ss.now).pres;
					temp.add(ss);
				}
				if (ss.presPm>maxMax) {
					maxMax=ss.presPm;
				}
				if (tr==false) {
					win.add(ss);
				}
			}
			percorso.clear();
			for (Strada ss:temp) {
				if (ss.minLeft<=0||ss.valLeft<=0) {
					win.add(ss);
				}
				else  if (ss.presPm>=maxMax-25)  {
					aggiungi(ss);
				}
			}
			temp.clear();
		}
		
		for (Strada ss:win) {
			while (ss.minLeft>0) {
				ss.passa();
			}
			if (ss.press>fin) {
				fin=ss.press;
			}
		}
		return (long) fin;
	}

	private static void aggiungi(Strada ss) {
		boolean tr=true;
		for (Strada ol:percorso) {
			if (ol.equals(ss)) {
				tr=false;
				break;
			}
		}
		if (tr) {
			percorso.add(ss);
		}
	}

	public static long calculate2(String s) {
		strade.clear();
		int fin=0;
		ArrayList<String[]> list=Read.elep(s);
		int maxMax=0;
		ArrayList<Percorsi> temp=new ArrayList<Percorsi>();
		ArrayList<Percorsi> win=new ArrayList<Percorsi>();
		int aper=list.size();
	
		for (String[] a:list) {
			Valve v=new Valve(a);
			if (v.aperto) {
				aper=aper-1;
			}
			Valve.agg(v);
		}
		Percorsi st=new Percorsi(new Valve(Valve.coll.get("AA")),aper);
		strade.add(st);
	
		while (strade.size()>0) {
			for (Percorsi ss:strade) {
				ss.passa();
				boolean tr=false;
				for (String nx:ss.strada.get(ss.now1).ele) {
					Percorsi te=new Percorsi(ss);
					if (te.vai(nx,1)) {
						tr=true;
						temp.add(te);
					}
				}
				if (ss.strada.get(ss.now1).aperto==false) {
					tr=true;
					ss.strada.get(ss.now1).open();
					ss.valLeft=ss.valLeft-1;
					ss.presPm=ss.presPm+ss.strada.get(ss.now1).pres;
					temp.add(ss);
				}
				if (ss.presPm>maxMax) {
					maxMax=ss.presPm;
				}
				if (tr==false) {
					win.add(ss);
				}
			}
			strade.clear();
			for (Percorsi ss:temp) {
				boolean tr=false;
				for (String nx:ss.strada.get(ss.now2).ele) {
					Percorsi te=new Percorsi(ss);
					if (te.vai(nx,2)) {
						tr=true;
						strade.add(te);
					}
				}
				if (ss.strada.get(ss.now2).aperto==false) {
					tr=true;
					ss.strada.get(ss.now2).open();
					ss.valLeft=ss.valLeft-1;
					ss.presPm=ss.presPm+ss.strada.get(ss.now2).pres;
					strade.add(ss);
				}
				if (ss.presPm>maxMax) {
					maxMax=ss.presPm;
				}
				if (tr==false) {
					win.add(ss);
				}
			}
			temp.clear();
			
			for (Percorsi ss:strade) {
				if (ss.minLeft<=0) {
					win.add(ss);
				}
				else {
					temp.add(ss);
				}
			}
			strade.clear();
			for (Percorsi ss:temp) {
				if (ss.presPm>=maxMax-25)  {
					aggiungi(ss);
				}
			}
			temp.clear();
		}
		
		for (Percorsi ss:win) {
			while (ss.minLeft>0) {
				ss.passa();
			}
			if (ss.press>fin) {
				fin=ss.press;
			}
		}
		return (long) fin;
	}

	private static void aggiungi(Percorsi ss) {
		boolean tr=true;
		for (Percorsi ol:strade) {
			if (ol.equals(ss)) {
				tr=false;
				break;
			}
		}
		if (tr) {
			strade.add(ss);
		}
	}
}
