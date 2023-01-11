package aOc22;

import java.util.HashMap;
import java.util.Map;

public class Percorsi {
	// day 16
	HashMap<String, Valve> strada=new HashMap<String, Valve>();
	String now1;
	String now2;
	int minLeft=26;
	int press=0;
	int presPm=0;
	int valLeft=0;
	
	public Percorsi(Valve x, int ape) {
		Valve v=new Valve(x);
		strada.put(v.name, v);
		now1=v.name;
		now2=v.name;
		valLeft=ape;
	}
	
	public Percorsi(Percorsi s) {
		for (Map.Entry<String, Valve> entry:s.strada.entrySet()) {
			Valve x=new Valve(entry.getValue());
			strada.put(x.name, x);
		}
		now1=s.now1;
		now2=s.now2;
		press=s.press;
		presPm=s.presPm;
		minLeft=s.minLeft;
		valLeft=s.valLeft;
	}
	
	public boolean vai(String x, int a) {
		try {
			Valve v=strada.get(x);
			if (v.volte>0) {
				strada.put(v.name, v);
				if (a==1) {
					now1=v.name;
				}
				else {
					now2=v.name;
				}
				v.volte=v.volte-1;
				return true;
			}
		}
		catch(Exception e) {
			Valve v=new Valve(Valve.coll.get(x));
			if (v.volte>0) {
				strada.put(v.name, v);
				if (a==1) {
					now1=v.name;
				}
				else {
					now2=v.name;
				}
				v.volte=v.volte-1;
				return true;
			}
		}

		return false;
	}
	
	public void passa() {
		minLeft=minLeft-1;
		press=press+presPm;
	}
	
	public boolean equals(Percorsi ss) {
		boolean tr=(ss.now1.equals(now1)&&ss.now2.equals(now2) || ss.now1.equals(now2)&&ss.now2.equals(now1));
		if (ss.presPm==presPm&&ss.valLeft==valLeft&&ss.press==press&&tr) {
			for (Valve vv:ss.strada.values()) {
				try {
					if (vv.equals(strada.get(vv.name))){
						return true;
					}
				}
				catch (Exception e) {}
			}
		}
		return false;
	}
}
