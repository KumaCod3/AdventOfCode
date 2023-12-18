package aOc23;
import java.util.ArrayList;

import program.Read;

public class Day18_2023 {
	private static ArrayList<String[]> list;
	private static ArrayList<long[]> coordinate=new ArrayList<long[]>();
	
	public static long calculate1(String s) {
		list = Read.copListN(s);
		long fin=0;
		fin=calculate();
		return fin;
	}
	
	public static long calculate2(String s) {
		long fin=99l;
		list = Read.copListN(s);
		for (String[] ss:list) {
			String hex=ss[2].substring(2, 7);
			String num=ss[2].substring(7, 8);
			String dir="";
			switch(num) {
				case "0":
					dir="R";
					break;
				case "1":
					dir="D";
					break;
				case "2":
					dir="L";
					break;
				case "3":
					dir="U";
					break;
				}
			Long col=Long.parseLong(hex, 16);
			ss[0]=dir;
			ss[1]=col+"";
		}
		fin=calculate();
		
		return fin;
	}
	public static long calculate() {
		long fin=0;
		long[] cor= {1,1,0};
		coordinate.add(cor);
		for (String[] ss:list) {
			String hex=ss[2].substring(2, 8);
			Long col=Long.parseLong(hex, 16);
			cor[2]=col;
			fin=fin+Integer.parseInt(ss[1]);
			for (int j=0;j<Integer.parseInt(ss[1]);j++) {
				switch(ss[0]) {
					case "R":
						cor[0]=cor[0];
						cor[1]=cor[1]+1;
						break;
					case "D":
						cor[0]=cor[0]+1;
						cor[1]=cor[1];
						break;
					case "L":
						cor[0]=cor[0];
						cor[1]=cor[1]-1;
						break;
					case "U":
						cor[0]=cor[0]-1;
						cor[1]=cor[1];
						break;
				}
				long[] temp= {cor[0],cor[1],cor[2]};
				if (j==Integer.parseInt(ss[1])-1) {
					coordinate.add(temp);
				}
			}
		}
	
		for (int i=coordinate.size()-1;i>0;i--) {
			long[] coa=coordinate.get(i);
			long[] cob=coordinate.get(i-1);
			long xa=coa[0];
			long ya=coa[1];
			long xb=cob[0];
			long yb=cob[1];
			long f=(xa*yb)-(ya*xb);
			fin=fin+f;
		}
		
		fin=Math.abs(fin)/2;
		return fin+1;
	}
}
