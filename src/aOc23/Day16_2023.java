package aOc23;

import java.util.ArrayList;

import program.Read;

public class Day16_2023 {
	private static char[][] list;
	
	public static long calculate1(String s) {
		list = Read.pips(s);
		long fin=0;
		int[] iniz= {0,0,11};
		fin=calculate(iniz);
		return fin;
	}
	
	public static long calculate2(String s) {
		list = Read.pips(s);
		long fin=0;
		ArrayList<int[]> inizi=new ArrayList<int[]>();
		for (int x=0;x<list.length;x++) {
			int[] cor1= {x,0,11};
			int[] cor2= {x,list[0].length-1,3};
			inizi.add(cor1);
			inizi.add(cor2);
		}
		for (int y=0;y<list[0].length;y++) {
			int[] cor1= {0,y,5};
			int[] cor2= {list.length-1,y,7};
			inizi.add(cor1);
			inizi.add(cor2);
		}
		
		for (int[] cor : inizi) {
			long prova=calculate(cor);
			if (prova>fin) {
				fin=prova;
			}
		}
		return fin;
	}
	
	public static long calculate(int[] nn) {
		int fin=0;
		int[][] illum=new int[list.length][];
		for (int i =0;i<list.length;i++) {
			int[] t=new int[list[1].length];
			illum[i]=t;
		}
		ArrayList<int[]> cor=new ArrayList<int[]>();
		ArrayList<int[]> temp=new ArrayList<int[]>();
		cor.add(nn);
		
		while (cor.size()>0) {
			for (int[] cc:cor) {// trovo prossimo step
				int[] cn= {cc[0], cc[1],cc[2]};
				
				//illumino e controllo direzione next step
				
				char ch=list[cn[0]][cn[1]];
				if (illum[cn[0]][cn[1]]==0) {
					illum[cn[0]][cn[1]]=cc[2];
				}
				else if (illum[cn[0]][cn[1]]%cc[2]==0) {
					continue;
				}
				else {
					illum[cn[0]][cn[1]]=illum[cn[0]][cn[1]]*cc[2];
				}
				int[] ncor= {cn[0],cn[1],cn[2]};
				switch(ch) {
					case '.':
						switch(cc[2]) {
							case 11:
								cn[1]=cn[1]+1;
								break;
							case 5:
								cn[0]=cn[0]+1;
								break;
							case 3:
								cn[1]=cn[1]-1;
								break;
							case 7:
								cn[0]=cn[0]-1;
								break;
						}
						temp.add(cn);
						break;
					case '-':
						switch(cn[2]) {
							case 11:
								ncor[1]=ncor[1]+1;
								temp.add(ncor);
								break;
							case 5:
								ncor[2]=11;
								ncor[1]=ncor[1]+1;
								cn[2]=3;
								cn[1]=cn[1]-1;
								temp.add(ncor);
								temp.add(cn);
								break;
							case 3:
								ncor[1]=ncor[1]-1;
								temp.add(ncor);
								break;
							case 7:
								ncor[2]=11;
								ncor[1]=ncor[1]+1;
								cn[2]=3;
								cn[1]=cn[1]-1;
								temp.add(ncor);
								temp.add(cn);
								break;
						}
						break;
					case '|':
						switch(cn[2]) {
							case 11:
								ncor[0]=ncor[0]+1;
								cn[0]=cn[0]-1;
								//dir
								ncor[2]=5;
								cn[2]=7;
								temp.add(ncor);
								temp.add(cn);
								break;
							case 5:
								ncor[0]=ncor[0]+1;
								temp.add(ncor);
								break;
							case 3:
								ncor[0]=ncor[0]+1;
								cn[0]=cn[0]-1;
								//dir
								ncor[2]=5;
								cn[2]=7;
								temp.add(ncor);
								temp.add(cn);
								break;
							case 7:
								ncor[0]=ncor[0]-1;
								temp.add(ncor);
								break;
						}
						break;
					case '/':// angolo
						switch(cn[2]) {
							case 11:
								ncor[0]=ncor[0]-1;
								ncor[2]=7;
								temp.add(ncor);
								break;
							case 5:
								ncor[2]=3;
								ncor[1]=ncor[1]-1;
								temp.add(ncor);
								break;
							case 3:
								ncor[0]=ncor[0]+1;
								ncor[2]=5;
								temp.add(ncor);
								break;
							case 7:
								ncor[2]=11;
								ncor[1]=ncor[1]+1;
								temp.add(ncor);
								break;
						}
						break;
					case 92: // \
						switch(cn[2]) {
							case 11:
								ncor[0]=ncor[0]+1;
								ncor[2]=5;
								temp.add(ncor);
								break;
							case 5:
								ncor[2]=11;
								ncor[1]=ncor[1]+1;
								temp.add(ncor);
								break;
							case 3:
								ncor[0]=ncor[0]-1;
								ncor[2]=7;
								temp.add(ncor);
								break;
							case 7:
								ncor[2]=3;
								ncor[1]=ncor[1]-1;
								temp.add(ncor);
								break;
						}
					break;
				
				}
			}
			cor.clear();
			for (int[] ch:temp) {
				if ((ch[0]>=0&&ch[0]<illum.length)&&(ch[1]>=0&&ch[1]<illum[0].length)) {
					cor.add(ch);
				}
			}
			temp.clear();
		}
		for (int[] n:illum) {
			for (int v:n) {
				if (v>0) {
					fin++;
				}
			}
		}
		return fin;
	}
}