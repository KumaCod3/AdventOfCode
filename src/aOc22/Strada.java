package aOc22;

import java.util.HashMap;
import java.util.Map;

public class Strada {
	// day 16
	HashMap<String, Valve> strada=new HashMap<String, Valve>();
	String now;
	int minLeft=30;
	int press=0;
	int presPm=0;
	int valLeft=0;
	
	public Strada(Valve x, int ape) {
		Valve v=new Valve(x);
		strada.put(v.name, v);
		now=v.name;
		valLeft=ape;
	}
	
	public Strada(Strada s) {
		for (Map.Entry<String, Valve> entry:s.strada.entrySet()) {
			Valve x=new Valve(entry.getValue());
			strada.put(x.name, x);
		}
		now=s.now;
		press=s.press;
		presPm=s.presPm;
		minLeft=s.minLeft;
		valLeft=s.valLeft;
	}
	
	public boolean vai(String x) {
		try {
			Valve v=strada.get(x);
			if (v.volte>0) {
				strada.put(v.name, v);
				now=v.name;
				v.volte=v.volte-1;
				passa();
				return true;
			}
		}
		catch(Exception e) {
			Valve v=new Valve(Valve.coll.get(x));
			if (v.volte>0) {
				strada.put(v.name, v);
				now=v.name;
				v.volte=v.volte-1;
				passa();
				return true;
			}
		}

		return false;
	}
	public void passa() {
		minLeft=minLeft-1;
		press=press+presPm;
	}
	
	public boolean equals(Strada ss) {
		if (ss.presPm==presPm&&ss.valLeft==valLeft&&ss.now.equals(now)&&ss.press==press) {
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
