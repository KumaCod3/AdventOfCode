package aOc22;
import java.util.HashMap;

public class Valve {
	public static HashMap<String, Valve> coll=new HashMap<String, Valve>();
	String[] ele;
	final String name;
	public final int pres;
	static final String start="AA";
	public int volte;
	boolean aperto=false;

	public Valve(String[] s) {
		int lun=s.length-10;
		ele=new String[lun];
		for (int i=10;i<s.length;i++) {
			ele[i-10]=s[i];
		}
		volte=ele.length;
		name=s[1];
		pres=Integer.parseInt(s[5]);
		if (pres==0) {
			aperto=true;
		}
	}
	public Valve(Valve v) {
		ele=new String[v.ele.length];
		for (int i=0;i<v.ele.length;i++) {
			ele[i]=v.ele[i];
		}
		volte=v.volte;
		name=v.name;
		pres=v.pres;
		aperto=v.aperto;
	}
	
	public void open() {
		aperto=true;
	}
	
	public String[] road() {
		return ele;
	}
	
	public static void agg(Valve v) {
		String n=v.name;
		coll.put(n, v);
	}
	
	public boolean equals(Valve v) {
		if (v.name.equals(name)&&v.volte==volte&&v.aperto==aperto) {
			return true;
		}
		return false;
	}
}
