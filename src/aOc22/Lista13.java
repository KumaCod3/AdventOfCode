package aOc22;

import java.util.ArrayList;

public class Lista13 {
	ArrayList<Object> lista;
	int x=0;
	int[] ar;
	
	public Lista13(int[] ss, int c) {
		x=c+1;
		ar=ss;
		lista=new ArrayList<Object>();
		for (;x<ss.length;x++) {
			if (ss[x]==-1) {
				Lista13 ll=new Lista13(ss,x);
				x=ll.x;
				lista.add(ll);
			}
			else if (ss[x]>=0) {
				Integer xx=ss[x];
				lista.add(xx);
			}
			else if (ss[x]==-2) {
				return;
			}
		}
	}
	
	public Lista13(Integer xx) {
		lista=new ArrayList<Object>();
		lista.add(xx);
	}
	
	public void aggiungi(Object oj) {
		lista.add(oj);
	}
	public String toString() {
		String fin="[";
		for (Object oj:lista) {
			if (oj instanceof Integer) {
				fin=fin+" "+oj;
			}
			else {
				String xx=oj.toString();
				fin=fin+xx;
			}
		}
		fin=fin+" ]";
		return fin;
	}
	
	public boolean equals(String line) {
		line=line.replace("[", " [ ");
		line=line.replace("]", " ] ");
		line=line.replace(",", " ");
		line=line.replace("  ", " ");
		line=line.replace("  ", " ");
		line=line.trim();
		line=line.replace("[", "-1");
		line=line.replace("]", "-2");
		String[] riga=line.split(" ");
		int[] rInt=new int[riga.length];
		for (int i=0;i<riga.length;i++) {
			rInt[i]=Integer.parseInt(riga[i]);
		}
		Lista13 comp=new Lista13(rInt,0);

		if (lista.size()==comp.lista.size()) {
			for (int i=0;i<lista.size();i++) {
				if (!lista.get(i).equals(comp.lista.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public boolean equals(int[] arr) {
		if (arr.length!=ar.length) {
			return false;
		}
		for (int i=0;i<arr.length;i++){
			if (arr[i]!=ar[i]) {
				return false;
			}
		}
		return true;
	}
}
