package aOc22;

import java.util.ArrayList;
import program.Read;

public class Day17_2022 {
	
	static ArrayList<Integer> intervallo=new ArrayList<Integer>();
	static ArrayList<Integer> input;
	static int index=0;
	static ArrayList<int[]> cave=new ArrayList<int[]>();
	static long roks=20000;
	static long gir=0;
	static long taglio=100;
	static long dimens=1;
	static long totR=1000000000000l;
	static long tolgo=totR-taglio;
	static long ripetiz=0;
	static long avanzo=0;
	static long fin;
	static long finee;
	
	public static long calculate1(String s) {
		roks=2023;
		doIt(s);
		return finee;
	}
	
	public static long calculate2(String s) {
		doIt(s);
		ripetiz=tolgo/dimens;
		avanzo=tolgo%dimens;
		doIt(s);
		return fin;
	}
	
	public static void doIt(String s) {
		index=0;
		try {
			input.clear();
		}
		catch (NullPointerException e) {}
		input=Read.tetris(s);
		PezziTet pp=new PezziTet();
		int tt=0;
		cave.clear();
		
		if (roks!=20000&&roks!=2023) {
			fin=(ripetiz*gir);
			roks=avanzo+taglio;
		}
		
		for (long i=1;i<=roks;i++) {
			for (int h=0;h<3;h++) {
				int[] vuoto=new int[7];
				cave.add(0, vuoto);
			}
			int[][] pezzo;
			if (i%5==1) {
				//primo
				pezzo=pp.get(1); 
				for(int h=0;h<pp.uno;h++) { 
					int[] vuoto=new int[7];
					cave.add(0, vuoto);
				}
			}
			else if (i%5==2) {
				//secondo
				pezzo=pp.get(2); 
				for(int h=0;h<pp.du;h++) { 
					int[] vuoto=new int[7];
					cave.add(0, vuoto);
				}
			}
			else if (i%5==3) {
				//terzo
				pezzo=pp.get(3); 
				for(int h=0;h<pp.tr;h++) { 
					int[] vuoto=new int[7];
					cave.add(0, vuoto);
				}
			}
			else if (i%5==4) {
				//quarto
				pezzo=pp.get(4); 
				for(int h=0;h<pp.qu;h++) { 
					int[] vuoto=new int[7];
					cave.add(0, vuoto);
				}
			}
			else  {
				//quinto
				pezzo=pp.get(5); 
				for(int h=0;h<pp.ci;h++) { 
					int[] vuoto=new int[7];
					cave.add(0, vuoto);
				}
			}
			while (true) {
				move(pezzo);
				if (fall(pezzo)) {
					break;
				}
			}
			clean();
			
			finee=cave.size();
				
			if (roks==20000) {
				if (i%taglio==0) {
					if (i==taglio) {
						tt=cave.size();
					}
					else {
						intervallo.add(cave.size()-tt);
						tt=cave.size();
					}
				}
			}
		}
		if (roks==taglio+avanzo) {
			fin=fin+finee;
		}
		else {
			roks=taglio+avanzo;
			misuroCiclo(intervallo.size()/2);
		}
		if (roks==2023) {
			return;
		}
	}
	
	static void misuroCiclo(int x) {
		int dimensione=x;
		long tot=0;
		boolean tr=true;
		for (int i=0;i<dimensione;i++) {
			if (intervallo.get(i).equals(intervallo.get(dimensione+i))) {
				tot=tot+intervallo.get(i);
			}
			else {
				tr=false;
				break;
			}
		}
		if (tr) {
			dimens=dimensione*taglio;
			gir=tot;
		}
		else {
			misuroCiclo(x-1);
		}
	}
	
	static void clean() {
		int count=0;
		boolean tr=true;
		for (int i=0;i<cave.size();i++) {
			tr=check(cave.get(i));
			if (tr==false) {
				break;
			}
			count++;
		}
		for (int i=0;i<count;i++) {
			cave.remove(0);
		}
	}
	
	static void move(int[][] pezzo) {
		int dir=0;
		boolean tr=true;
		try {
			dir=input.get(index);
		}
		catch (Exception e) {
			index=0;
			dir=input.get(index);
		}
		if (dir==1) {
			for (int[] cor:pezzo) {
				if (cor[1]==6) {
					tr=false;
					break;
				}
				else if (cave.get(cor[0])[cor[1]+1]==9) {
					tr=false;
					break;
				}
			}
			if (tr) {
				for (int[] cor:pezzo) {
					cor[1]=cor[1]+1;
				}
			}
		}
		else if (dir==-1) {
			for (int[] cor:pezzo) {
				if (cor[1]==0) {
					tr=false;
					break;
				}
				else if (cave.get(cor[0])[cor[1]-1]==9) {
					tr=false;
					break;
				}
			}
			if (tr) {
				for (int[] cor:pezzo) {
					cor[1]=cor[1]-1;
				}
			}
		}
		index++;
	}
	
	static boolean fall(int[][] pezzo){
		boolean tr=false;
		for (int[] cor:pezzo) {
			try {
				if (cave.get(cor[0]+1)[cor[1]]==9) {
					tr=true;
				}
			}
			catch (Exception e) {
				tr=true;
			}
		}
		if (tr) {
			for (int[] cor:pezzo) {
				cave.get(cor[0])[cor[1]]=9;
			}
		}
		else {
			for (int[] cor:pezzo) {
				cor[0]=cor[0]+1;
			}
		}
		return tr;
	}
	
	static public boolean check(int[] x) {
		for (int y:x) {
			if (y!=0) {
				return false;
			}
		}
		return true;
	}
}
