package aOc22;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import program.Read;

public class Day15_2022 {
	
	public static long calculate1(String s) {
		int fin=0;
		ArrayList<int[]> lista=Read.bacon(s);
		int coorYfin=2000000;
		HashMap<Integer,Integer> finn=new HashMap<Integer,Integer>();

		ArrayList<int[]> riga=new ArrayList<int[]>();
		for (int[] cor:lista) {
			int dist=Math.abs(cor[2]-cor[0])+Math.abs(cor[3]-cor[1]);
			int alfa=Math.abs(coorYfin-cor[1]);
			int delta=dist-alfa;
			if (delta>=0) {
				int[] coor= {cor[0]-delta, cor[0]+delta};
				riga.add(coor);
			}
		}
		for (int[] coor:riga) {
			System.out.println(Arrays.toString(coor));
			if (coor[0]<coor[1]) {
				for (int i=coor[0];i<=coor[1];i++) {
					finn.put(i, i);
				}
			}
			else {
				for (int i=coor[1];i<=coor[0];i++) {
					finn.put(i, i);
				}
			}
		}
		for (int[] cor:lista) {
			if (cor[3]==coorYfin) {
				finn.remove(cor[2]);
			}
		}
		fin=finn.size();
		System.out.println(" boo ");
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		long fin=0;
		ArrayList<int[]> lista=Read.bacon(s);
		int max=4000000;
		int finX=-1;
		int finY=-1;
		boolean tr=false;
		ArrayList<int[]> bordi=new ArrayList<int[]>();
		
		for (int[] dina:lista) {
			int[] cor= {dina[0],dina[1],dina[2],dina[3]};
			if (cor[0]>cor[2]) {
				cor[2]=cor[2]-1;
			}
			else if (cor[0]<cor[2]) {
				cor[2]=cor[2]+1;
			}
			else if (cor[1]>cor[3]) {
				cor[3]=cor[3]-1;
			}
			else if (cor[1]<cor[3]) {
				cor[3]=cor[3]+1;
			}
			
			int dist=Math.abs(cor[2]-cor[0])+Math.abs(cor[3]-cor[1]);
			for (int i=0;i<dist;i++) {
				finY=cor[1]+i;
				int finY2=cor[1]-i;
				int alfa=Math.abs(finY-cor[1]);
				int delta=dist-alfa;
				if (delta>=0) {
					int[] ok1= {cor[0]-delta, finY};
					int[] ok2= {cor[0]+delta, finY};
					int[] ok3= {cor[0]-delta, finY2};
					int[] ok4= {cor[0]+delta, finY2};
					bordi.add(ok1);
					bordi.add(ok2);
					bordi.add(ok3);
					bordi.add(ok4);
				}
			}
		}

		for (int[] coor:bordi) {
			tr=true;
			finX=coor[0];
			finY=coor[1];
			if (!(finX>=0&&finX<=max&&finY>=0&&finY<=max)) {
				tr=false;
				continue;
			}
			for (int[] cor:lista) {
				int dist=Math.abs(cor[2]-cor[0])+Math.abs(cor[3]-cor[1]);
				int alfa=Math.abs(finY-cor[1]);
				int delta=dist-alfa;
				if (delta>=0) {
					int[] ok= {cor[0]-delta, cor[0]+delta};
					if (finX>=ok[0]&&finX<=ok[1]) {
						tr=false;
						break;
					}
				}
			}
			if (tr==true) {
				break;
			}
		}
			
		long x=(long) finX;	
		System.out.println("yups: "+finY);
		fin=(x*4000000)+finY;
		System.out.println(" boo ");
		return fin;
	}
}
