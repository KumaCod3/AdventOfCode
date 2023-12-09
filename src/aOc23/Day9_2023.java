package aOc23;
import java.util.ArrayList;
import java.util.LinkedList;
import program.Read;

public class Day9_2023 {
	public static long calculate1(String s) {
		Long fin=0l;
		ArrayList<int[]> lista = Read.simple(s);
		
		for (int[] n:lista) {
			LinkedList<int[]>espando=new LinkedList<int[]>();
			espando.add(n);
			while (true) {
				int[] nuovo=estrapola(espando.get(espando.size()-1));
				if (check(nuovo)) {
					int[] nnn=new int[nuovo.length+1];
					for (int i=0;i<nuovo.length;i++) {
						nnn[i]=nuovo[i];
					}
					espando.add(nnn);
					break;
				}
				else {
					espando.add(nuovo);
				}
			}
			for (int i=espando.size()-1;i>0;i--) {
				int[] nuovo=intrapola(espando.get(i),espando.get(i-1));
				espando.set(i-1,nuovo);
			}
			long x=espando.get(0)[espando.get(0).length-1];
			fin=fin+x;
		}
		return fin;
	}	
	
	static boolean check(int[] n) {
		for (int nn:n) {
			if (nn!=0) {
				return false;
			}
		}
		return true;
	}
	
	static int[] estrapola (int[] n1) {
		int[] n2=new int[n1.length-1];
		for (int i=0;i<n2.length;i++) {
			int x=n1[i+1]-n1[i];
			n2[i]=x;
		}
		return n2;
	}
	static int[] intrapola (int[] n2,int[] nn) {
		int[] n1=new int[nn.length+1];
		for (int i=0;i<nn.length;i++) {
			n1[i]=nn[i];
		}
		int i=n1.length-2;
		int x=n1[i]+n2[i];
		n1[i+1]=x;
		return n1;
	}
	public static long calculate2(String s) {
		Long fin=0l;
		ArrayList<int[]> lista = Read.simple(s);
		
		for (int[] n:lista) {
			LinkedList<int[]>espando=new LinkedList<int[]>();
			espando.add(n);
			while (true) {
				int[] nuovo=estrapola(espando.get(espando.size()-1));
				if (check(nuovo)) {
					int[] nnn=new int[nuovo.length+1];
					for (int i=0;i<nuovo.length;i++) {
						nnn[i+1]=nuovo[i];
					}
					espando.add(nnn);
					break;
				}
				else {
					espando.add(nuovo);
				}
			}
			for (int i=espando.size()-1;i>0;i--) {
				int[] nuovo=intrapola2(espando.get(i),espando.get(i-1));
				espando.set(i-1,nuovo);
			}
			long x=espando.get(0)[0];
			fin=fin+x;
		}
		return fin;
	}
	
	static int[] intrapola2 (int[] n2,int[] nn) {
		int[] n1=new int[nn.length+1];
		for (int i=0;i<nn.length;i++) {
			n1[i+1]=nn[i];
		}
		int i=0;
		int x=n1[i+1]-n2[i];
		n1[i]=x;
		return n1;
	}
}
