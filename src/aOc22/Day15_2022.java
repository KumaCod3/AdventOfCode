package aOc22;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingWorker;

import program.Program;
import program.Read;
import program.Show;

public class Day15_2022 {
	static ArrayList<int[]> bordi=new ArrayList<int[]>();
	static ArrayList<int[]> lista;
	static int max=4000000;
	
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
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		Show ss=new Show("Please waith, this should take an average of 5 seconds...");
		ss.setVisible(true);
		
		SwingWorker<Long, Void> worker = new SwingWorker<Long, Void>() { @Override
				    public Long doInBackground() {
						return calc(s);
			    }
		
			    @Override
			    public void done() {
			    	 try {
			        	 Program.resulT.setText(""+get());
			        	 ss.dispose();
			        	 
			         } catch (Exception ignore) {}
			    }
			};
		worker.execute();
		return 0;
	}
	
	public static long calc(String s) {
		bordi.clear();
		lista=Read.bacon(s);
		ArrayList<int[]> temp=new ArrayList<int[]>();
		
		for (int[] dina:lista) {
			temp.clear();
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
			for (int i=0;i<=dist;i++) {
				int finY=cor[1]+i;
				int finY2=cor[1]-i;
				int delta=dist-i;
				if (delta>=0) {
					int[] ok1= {cor[0]-delta, finY};
					int[] ok2= {cor[0]+delta, finY};
					int[] ok3= {cor[0]-delta, finY2};
					int[] ok4= {cor[0]+delta, finY2};
					temp.add(ok1);
					temp.add(ok2);
					temp.add(ok3);
					temp.add(ok4);
				}
			}
			compare(temp);
		}

		BigInteger xx=new BigInteger(bordi.get(0)[0]+"");
		xx=xx.multiply(new BigInteger("4000000"));
		xx=xx.add(new BigInteger(""+bordi.get(0)[1]));
		Show ss=new Show(" "+xx);
		ss.setVisible(true);
		return 0;
	}
	
	static void agg(int[] ok) {
		boolean tr=true;
		for (int[] b:bordi) {
			if (b[0]==ok[0]&&b[1]==ok[1]) {
				tr=false;
			}
		}
		if (tr) {
			bordi.add(ok);
		}
	}
	
	static void compare(ArrayList<int[]> b) {
		for (int[] cor:b) {
			boolean tr=true;
			for (int[] orig:lista) {
				int dist=Math.abs(cor[0]-orig[0])+Math.abs(cor[1]-orig[1]);
				if (dist<=orig[4]||cor[0]>max||cor[1]>max||cor[0]<0||cor[1]<0) {
					tr=false;
					break;
				}
			}
			if (tr) {
				agg(cor);
			}
		}
	}
}