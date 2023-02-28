package aOc22;
import java.util.ArrayList;
import program.Read;

public class Day8_2022 {
	static ArrayList<int[]> list;
	
	public static long calculate1(String s) {
		int fin=0;
		list=Read.intArList(s);
		
		for (int x=0;x<list.size();x++) {
			for (int y=0;y<list.get(0).length;y++) {
				if (isVisible(x,y)) {
					fin=fin+1;
				}
				else {
					System.out.println("falso  ");
					System.out.println("     "+x+y);
				}
			}
		}
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		int fin=0;
		list=Read.intArList(s);
		
		for (int x=1;x<list.size()-1;x++) {
			for (int y=1;y<list.get(0).length-1;y++) {
				int pro=scenic(x,y);
				if (pro>fin) {
					fin=pro;
				}
			}
		}
		return (long) fin;
	}
	
	private static boolean isVisible(int x, int y) {
		System.out.println("Provo "+x+y);
		boolean tr=true;
		int ind=list.get(x)[y];
		System.out.println("     "+ind);
		for (int i=0;i<x;i++) {
			int es=list.get(i)[y];
			System.out.println(ind+"  e>di   "+es);
			
			if (es>=ind) {
				System.out.println("falso 1");
				tr=false;
				break;
			}
		}
		if(tr) {System.out.println("vero ");return tr;}
		tr=true;
		for (int h=0;h<y;h++) {
			int es=list.get(x)[h];
			if (es>=ind) {
				System.out.println("falso 2");
				tr=false;
				break;
			}	
		}
		if(tr) {System.out.println("vero ");return tr;}
		tr=true;
		for (int i=list.size()-1;i>x;i--) {
			int es=list.get(i)[y];
			if (es>=ind) {
				System.out.println("falso 3");
				tr=false;
				break;
			}
		}
		if(tr) {System.out.println("vero ");return tr;}
		tr=true;
		for (int h=list.get(x).length-1;h>y;h--) {
			int es=list.get(x)[h];
			if (es>=ind) {
				System.out.println("falso 4"+list.get(x)[h-1]+" e ");
				tr=false;
				break;
			}	
		}
		System.out.println("e "+tr);
		return tr;
	}
	
	private static int scenic(int x, int y) {
		int pro=0;
		int ind=list.get(x)[y];
		int pre=ind;
		int di=0;
		int si=0;
		int su=0;
		int gu=0;

		for (int i=x-1;i>=0;i--) {
			pre=list.get(i)[y];
			System.out.println("agg 1");
			si=si+1;
			if (pre>=ind) {
				break;
			}
		}
		for (int h=y-1;h>=0;h--) {
			pre=list.get(x)[h];
			su=su+1;
			if (pre>=ind) {
				break;
			}
		}
		for (int i=x+1;i<list.size();i++) {
			pre=list.get(i)[y];
			di=di+1;
			if (pre>=ind) {
				break;
			}
		}
		for (int h=y+1;h<list.get(x).length;h++) {
			pre=list.get(x)[h];
			gu=gu+1;
			if (pre>=ind) {
				break;
			}
		}
		
		pro=di*si*su*gu;
		System.out.println("metto  "+x+y+" tot "+pro);
		System.out.println("fatto  "+di+si+su+gu);
		return pro;
	}
}
