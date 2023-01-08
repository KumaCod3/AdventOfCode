package aOc22;

import java.util.ArrayList;

public class PezziTet {
	public ArrayList<int[]> primo=new ArrayList<int[]>();
	public ArrayList<int[]> secondo=new ArrayList<int[]>();
	public ArrayList<int[]> terzo=new ArrayList<int[]>();
	public ArrayList<int[]> quarto=new ArrayList<int[]>();
	public ArrayList<int[]> quinto=new ArrayList<int[]>();
	
	final int[][] limitiP= {{2,5},{0,0},{0,0},{0,0}};
	final int[][] limitiS= {{3,3},{2,4},{3,3},{0,0}};
	final int[][] limitiT= {{4,4},{4,4},{2,4},{0,0}};
	final int[][] limitiQ= {{2,2},{2,2},{2,2},{2,2}};
	final int[][] limitiQI={{2,3},{2,3},{0,0},{0,0}};	
	
	final public int[][] pri={{0,2},{0,3},{0,4},{0,5}};
	final public int[][] sec={{0,3},{1,2},{1,3},{1,4},{2,3}};
	final public int[][] ter={{0,4},{1,4},{2,2},{2,3},{2,4}};
	final public int[][] qua={{0,2},{1,2},{2,2},{3,2}};
	final public int[][] qui={{0,2},{0,3},{1,2},{1,3}};
	
	final public int uno=1;
	final public int du=3;
	final public int tr=3;
	final public int qu=4;
	final public int ci=2;
	
	public PezziTet() {
		int[] a= {0,0,9,9,9,9,0};
		primo.add(a);
		
		int[] b= {0,0,0,1,0,0,0};
		secondo.add(b);
		int[] c= {0,0,1,1,1,0,0};
		secondo.add(c);
		int[] d= {0,0,0,1,0,0,0};
		secondo.add(d);
		
		int[] g= {0,0,1,1,1,0,0};
		terzo.add(g);
		int[] e= {0,0,0,0,1,0,0};
		terzo.add(e);
		int[] f= {0,0,0,0,1,0,0};
		terzo.add(f);
		
		int[] h= {0,0,1,0,0,0,0};
		quarto.add(h);
		int[] i= {0,0,1,0,0,0,0};
		quarto.add(i);
		int[] j= {0,0,1,0,0,0,0};
		quarto.add(j);
		int[] k= {0,0,1,0,0,0,0};
		quarto.add(k);
		
		int[] l= {0,0,1,1,0,0,0};
		quinto.add(l);
		int[] m= {0,0,1,1,0,0,0};
		quinto.add(m);
	}
	
	public int[][] get(int x){
		int[][] fin;
		
		switch(x) {
		case 1:
			fin=new int[pri.length][];  // pri
			for (int i=0; i<pri.length;i++) { // pri
				int[] t=new int[2];
				t[0]=pri[i][0];
				t[1]=pri[i][1];
				fin[i]=t;
			}
			break;
		case 2:
			fin=new int[sec.length][];  // sec
			for (int i=0; i<sec.length;i++) { // sec
				int[] t=new int[2];
				t[0]=sec[i][0];
				t[1]=sec[i][1];
				fin[i]=t;
			}
			break;
		case 3:
			fin=new int[ter.length][];  // ter
			for (int i=0; i<ter.length;i++) { // ter
				int[] t=new int[2];
				t[0]=ter[i][0];
				t[1]=ter[i][1];
				fin[i]=t;
			}
			break;
		case 4:
			fin=new int[qua.length][];  // qua
			for (int i=0; i<qua.length;i++) { // qua
				int[] t=new int[2];
				t[0]=qua[i][0];
				t[1]=qua[i][1];
				fin[i]=t;
			}
			break;
		case 5:
			fin=new int[qui.length][];  // qui
			for (int i=0; i<qui.length;i++) { // qui
				int[] t=new int[2];
				t[0]=qui[i][0];
				t[1]=qui[i][1];
				fin[i]=t;
			}
			break;
		default:
			fin=new int[1][1];
		}
		return fin;
	}
}
