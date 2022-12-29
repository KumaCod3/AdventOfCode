package aOc22;

import java.util.ArrayList;
import java.util.LinkedList;

import program.Nope;
import program.Read;

public class Day18_2022 {
	
	public static long calculate1(String s) {
		long fin=0l;
		LinkedList<int[]> list= Read.coorDop(s);
		ArrayList<int[]> lista=new ArrayList<int[]>();
		for (int[] in:list) {
			int[] nn=new int[in.length+1];
			for (int i=0;i<in.length;i++) {
				nn[i]=in[i];
			}
			lista.add(nn);
		}
		for (int[] cor:lista) {
			int a=cor[0];
			int b=cor[1];
			int c=cor[2];
			for (int[] par:lista) {
				int aa=par[0];
				int bb=par[1];
				int cc=par[2];
				if (a==aa&&b==bb) {
					if (c==cc-1||c==cc+1) {
						cor[3]=cor[3]+1;
					}
				}
				if (a==aa&&c==cc) {
					if (b==bb-1||b==bb+1) {
						cor[3]=cor[3]+1;
					}
				}
				if (b==bb&&c==cc) {
					if (a==aa-1||a==aa+1) {
						cor[3]=cor[3]+1;
					}
				}
			}
		}
		int tot=0;
		for (int[] cor:lista) {
			tot=tot+cor[3];
		}
		fin=(lista.size()*6)-tot;
		return fin;
	}
	
	public static long calculate2(String s) {
		long fin=0l;
		LinkedList<int[]> list= Read.coorDop(s);
		ArrayList<int[]> olio= new ArrayList<int[]>();
		ArrayList<int[]> temp= new ArrayList<int[]>();
		ArrayList<int[]> vuoti= new ArrayList<int[]>();
		ArrayList<int[]> vuo= new ArrayList<int[]>();
		int xMas=0;

		for (int[] cor:list) {
			if (cor[0]>xMas) {
				xMas=cor[0];
			}
			if (cor[1]>xMas) {
				xMas=cor[1];
			}
			if (cor[2]>xMas) {
				xMas=cor[2];
			}
		}
		xMas=xMas+1;
		
		int[][][] tavola=new int[xMas+1][][];
		for (int h=0;h<=xMas;h++) {
			int[][] z=new int[xMas+1][];
			for (int i=0;i<=xMas;i++) {
				int[] y=new int[xMas+1];
				z[i]=y;
			}
			tavola[h]=z;
		}
		
		for (int[] cor:list) {
			tavola[cor[0]][cor[1]][cor[2]]=9;
		}
		int[] a= {0,0,0};
		int[] b= {xMas-1,xMas-1,xMas-1};
		int[] c= {xMas-1,xMas-1,0};
		int[] d= {0,xMas-1,xMas-1};
		int[] e= {xMas-1,0,xMas-1};
		int[] f= {xMas-1,0,0};
		int[] g= {0,xMas-1,0};
		int[] h= {0,0,xMas-1};
		temp.add(a);
		temp.add(b);
		temp.add(c);
		temp.add(d);
		temp.add(e);
		temp.add(f);
		temp.add(g);
		temp.add(h);
		for (int[] t:temp) {
			if (tavola[t[0]][t[1]][t[2]]==0){
				olio.add(t);
			}
		}
		temp.clear();
		
		while (olio.size()>0) {
			for (int[] cor:olio) {
				int[] uno= {cor[0]+1,cor[1],cor[2]};
				int[] due= {cor[0]-1,cor[1],cor[2]};
				int[] tre= {cor[0],cor[1]+1,cor[2]};
				int[] quat= {cor[0],cor[1]-1,cor[2]};
				int[] cinq= {cor[0],cor[1],cor[2]+1};
				int[] sei= {cor[0],cor[1],cor[2]-1};
				temp.add(uno);
				temp.add(due);
				temp.add(tre);
				temp.add(quat);
				temp.add(cinq);
				temp.add(sei);
			}
			olio.clear();
			for (int[] cor:temp) {
				if (cor[0]>=0&&cor[1]>=0&&cor[2]>=0&&cor[0]<xMas&&cor[1]<xMas&&cor[2]<xMas)
				if (tavola[cor[0]][cor[1]][cor[2]]==0) {
					tavola[cor[0]][cor[1]][cor[2]]=4;
					olio.add(cor);
				}
			}
		}
			
		for (int z=0;z<xMas;z++) {	//int[][] z:tavola
			for (int y=0;y<xMas;y++) {	// int[] y:z
				for (int x=0;x<xMas;x++) {	// int x:y
					if (tavola[z][y][x]==0) {
						int[] coor= {x,y,z};
						vuoti.add(coor);
					}
				}
			}
		}
		
		for (int[] in:vuoti) {
			int[] nn=new int[in.length+1];
			for (int i=0;i<in.length;i++) {
				nn[i]=in[i];
			}
			vuo.add(nn);
		}
		
		for (int[] cor:vuo) {
			int j=cor[0];
			int k=cor[1];
			int l=cor[2];
			for (int[] par:vuo) {
				int jj=par[0];
				int kk=par[1];
				int ll=par[2];
				if (j==jj&&k==kk) {
					if (l==ll-1||l==ll+1) {
						cor[3]=cor[3]+1;
					}
				}
				if (j==jj&&l==ll) {
					if (k==kk-1||k==kk+1) {
						cor[3]=cor[3]+1;
					}
				}
				if (k==kk&&l==ll) {
					if (j==jj-1||j==jj+1) {
						cor[3]=cor[3]+1;
					}
				}
			}
		}
		int tot=0;
		for (int[] cor:vuo) {
			tot=tot+cor[3];
		}
		int pareti=(vuo.size()*6)-tot;
		long lava=calculate1(s);
		fin=lava-pareti;
		return fin;
	}
}
