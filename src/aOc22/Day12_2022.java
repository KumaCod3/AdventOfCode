package aOc22;

import java.util.ArrayList;
import java.util.Arrays;

import program.Nope;
import program.Read;

public class Day12_2022 {
	
	public static int[] corI=new int[2];
	public static int[] corF=new int[2];
	static ArrayList<int[]> percorsi=new ArrayList<int[]>();
	//// PARTE 2 OK PARTE 1 DA SISTEMARE E PUSH
	
	public static long calculate1(String s) {
		int fin=0;
		int[][] list = Read.copAlt(s);
		ArrayList<int[]> temp=new ArrayList<int[]>();
		
		percorsi.add(corI);
		boolean tr=true;
		
		while (tr) {
			fin=fin+1;
			for (int[] so:percorsi) {
				int val=list[so[0]][so[1]];
				try {
					if (list[so[0]-1][so[1]]<=val+1) {
						int[] t={so[0]-1,so[1]};
						temp.add(t);
						if(t[0]==corF[0]&&t[1]==corF[1]) {
							tr=false;
							break;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {}
				try {
					if (list[so[0]][so[1]-1]<=val+1) {
						int[] t={so[0],so[1]-1};
						temp.add(t);
						if(t[0]==corF[0]&&t[1]==corF[1]) {
							tr=false;
							break;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {}
				
				try {
					if (list[so[0]+1][so[1]]<=val+1) {
						int[] t={so[0]+1,so[1]};
						temp.add(t);
						if(t[0]==corF[0]&&t[1]==corF[1]) {
							tr=false;
							break;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {}
				
				try {
					if (list[so[0]][so[1]+1]<=val+1) {
						int[] t={so[0],so[1]+1};
						temp.add(t);
						if(t[0]==corF[0]&&t[1]==corF[1]) {
							tr=false;
							break;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {}
				
			}
			for (int[] so:temp) {
				agg(so);
			}
			temp.clear();
		}
		return (long) fin;
	}

	static public void agg(int[] so){
		boolean gia=false;
		for (int[] co:percorsi) {
			if (co[0]==so[0]&&co[1]==so[1]) {
				gia=true;
			}
		}
		if (gia==false) {
			percorsi.add(so);
		}
	}
	
	public static long calculate2(String s) {
		int fin=0;
		int[][] list = Read.copAlt(s);
		
		for (int i=0;i<list.length;i++) {
			for (int h=0;h<list[0].length;h++) {
				int[] te= {i,h};
				int val=list[i][h];
				if (val==1) {
					percorsi.add(te);
				}
			}
		}
		ArrayList<int[]> temp=new ArrayList<int[]>();
		boolean tr=true;
		
		while (tr) {
			fin=fin+1;
			for (int[] so:percorsi) {
				int val=list[so[0]][so[1]];
				try {
					if (list[so[0]-1][so[1]]<=val+1) {
						
						int[] t={so[0]-1,so[1]};
						temp.add(t);
						if(t[0]==corF[0]&&t[1]==corF[1]) {
							tr=false;
							break;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {}
				try {
					if (list[so[0]][so[1]-1]<=val+1) {
						int[] t={so[0],so[1]-1};
						temp.add(t);
						if(t[0]==corF[0]&&t[1]==corF[1]) {
							tr=false;
							break;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {}
				
				try {
					if (list[so[0]+1][so[1]]<=val+1) {
						
						int[] t={so[0]+1,so[1]};
						temp.add(t);
						if(t[0]==corF[0]&&t[1]==corF[1]) {
							tr=false;
							break;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {}
				
				try {
					if (list[so[0]][so[1]+1]<=val+1) {
						
						int[] t={so[0],so[1]+1};
						temp.add(t);
						if(t[0]==corF[0]&&t[1]==corF[1]) {
							tr=false;
							break;
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {}
			}
			for (int[] so:temp) {
				agg(so);
			}
			temp.clear();
		}
		return (long) fin;
	}
}
