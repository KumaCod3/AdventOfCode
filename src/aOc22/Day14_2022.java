package aOc22;
import java.util.ArrayList;
import java.util.Arrays;
import program.Read;

public class Day14_2022 {
	public static long calculate1(String s) {
		int fin=0;
		ArrayList<int[][]> lista=Read.sand(s);
		int[][] tab=new int[200][1000];
		
		for (int[][] riga:lista) {
			int x=riga[0][0];
			int y=riga[0][1];
			for (int i=1;i<riga.length;i++) {
				int[] cop=riga[i];
				if (x<=cop[0]) {
					for (int xx=x;xx<=cop[0];xx++) {
						if (y<=cop[1]) {
							for  (int yy=y;yy<=cop[1];yy++) {
								tab[yy][xx]=1;
							}
						}
						else {
							for  (int yy=cop[1];yy<=y;yy++) {
								System.out.println(yy+" , "+xx);
								tab[yy][xx]=1;
							}
						}
					}
				}
				else {
					for (int xx=cop[0];xx<=x;xx++) {
						if (y<=cop[1]) {
							for  (int yy=y;yy<=cop[1];yy++) {
								System.out.println(yy+" , "+xx);
								tab[yy][xx]=1;
							}
						}
						else {
							for  (int yy=cop[1];yy<=y;yy++) {
								System.out.println(yy+" , "+xx);
								tab[yy][xx]=1;
							}
						}
					}
				}
				x=cop[0];
				y=cop[1];
			}
		}
		for (int[] gg:tab) {
			System.out.println(Arrays.toString(gg));
		}
		while (true) {
			try {
				fin=fin+1;
				int x=500;
				int y=0;
				while (true) {
					if (tab[y+1][x]==0) {
						y=y+1;
					}
					else if(tab[y+1][x-1]==0) {
						y=y+1;
						x=x-1;
					}
					else if (tab[y+1][x+1]==0) {
						y=y+1;
						x=x+1;
					}
					else {
						tab[y][x]=9;
						break;
					}
				}
			}
			catch (Exception e) {
				break;
			}
		}
		return (long) fin-1;
	}

	public static long calculate2(String s) {
		int fin=0;
		ArrayList<int[][]> lista=Read.sand(s);
		int max=0;
		for (int[][] riga:lista) {
			for (int[] cor:riga) {
				if(cor[1]>max) {
					max=cor[1];
				}
			}
		}
		max=max+3;
		int[][] tab=new int[max][1000];
		for (int i=0;i<1000;i++) {
			tab[max-1][i]=1;
		}
		
		for (int[][] riga:lista) {
			int x=riga[0][0];
			int y=riga[0][1];
			for (int i=1;i<riga.length;i++) {
				int[] cop=riga[i];
				if (x<=cop[0]) {
					for (int xx=x;xx<=cop[0];xx++) {
						if (y<=cop[1]) {
							for  (int yy=y;yy<=cop[1];yy++) {
								tab[yy][xx]=1;
							}
						}
						else {
							for  (int yy=cop[1];yy<=y;yy++) {
								System.out.println(yy+" , "+xx);
								tab[yy][xx]=1;
							}
						}
					}
				}
				else {
					for (int xx=cop[0];xx<=x;xx++) {
						if (y<=cop[1]) {
							for  (int yy=y;yy<=cop[1];yy++) {
								System.out.println(yy+" , "+xx);
								tab[yy][xx]=1;
							}
						}
						else {
							for  (int yy=cop[1];yy<=y;yy++) {
								System.out.println(yy+" , "+xx);
								tab[yy][xx]=1;
							}
						}
					}
				}
				x=cop[0];
				y=cop[1];
			}
		}

		boolean tr=true;
		while (tr) {	// fino al fondo vuoto
			fin=fin+1;
			int x=500;
			int y=0;
			while (true) {	// finche si muove
				if (tab[y][x]!=0) {
					tr=false;
					break;
				}
				if (tab[y+1][x]==0) {
					y=y+1;
				}
				else if(tab[y+1][x-1]==0) {
					y=y+1;
					x=x-1;
				}
				else if (tab[y+1][x+1]==0) {
					y=y+1;
					x=x+1;
				}
				else {
					tab[y][x]=9;
					break;
				}
			}
			
		}
//		for (int[] gg:tab) {
//			System.out.println(Arrays.toString(gg));
//		}
		return (long) fin-1;
	}
}