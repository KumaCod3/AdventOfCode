package aOc23;
import java.util.ArrayList;
import java.util.LinkedList;
import program.Read;

public class Day15_2023 {
	public static LinkedList<String[]> bx= new LinkedList<String[]>();
	
	public static long calculate1(String s) {
		ArrayList<String> lista = Read.singvir(s);
		int fin=0;
		
		for (String ss:lista) {
			int ff=calcola(ss);
			fin=fin+ff;
		}
			
		return (long) fin;
	}
	
	static private int calcola(String g) {
		int ff=0;
		for (int i=0;i<g.length();i++) {
			
			char ch=g.charAt(i);
			int n=ch;
			ff=ff+n;
			ff=ff*17;
			ff=ff%256;
			
		}
		return ff;
	}
	
	public static long calculate2(String s) {
		ArrayList<String> lista = Read.singvir(s);
		Long fin=0l;		
		for (int i=0;i<lista.size();i++) {
			String ss=lista.get(i);
			String[] tp=ss.split("=");
			
			if (tp.length==1) {
				String pp=tp[0].substring(0, tp[0].length()-1);
				int ff=calcola(pp);
				togli(pp,ff);
			}
			else {
				int ff=calcola(tp[0]);
				aggiungi(tp,ff);
			}
		}
		LinkedList<int[]> kk=new LinkedList<int[]>();
		for (String[] ss:bx) {	
			int bxx=calcola(ss[0]);
			int val=Integer.parseInt(ss[1]);
			int[] ar= {bxx,val};
			kk.add(ar);
		}
		fin=0l;
		for (int i=0;i<257;i++) {
			int j=1;
			for (int l=0;l<kk.size();l++) {
				int[] ar=kk.get(l);
				
				if (ar[0]==i) {
					int tp=(i+1)*(j)*ar[1];
					fin=fin+tp;
					j++;
				}
			}
		}
		
		return  fin;
	}
	
	private static void aggiungi(String[] tp, int ff) {

		for (String[] cop:bx) {
			if (cop[0].equals(tp[0])) {
				cop[1]=tp[1];
				return;
			}
		}
		bx.add(tp);
	}

	private static void togli(String pp, int ff) {
		for (int i=0;i<bx.size();i++) {
			String[] cop=bx.get(i);
			if (cop[0].equals(pp)) {
				bx.remove(i);
				return;
			}
		}
	}
}
