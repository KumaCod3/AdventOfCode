package aOc22;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.SwingWorker;
import program.Program;
import program.Read;
import program.Show;

public class Day23_2022 {
	static int[][] tavola;
	static ArrayList<int[]> elfi=new ArrayList<int[]>();
	static int xMas=0;
	static int yMas=0;
	static int xMin=0;
	static int yMin=0;
	static long ddd=0;
	
	public static long calculate1(String s) {
		int fin=0;
		int giri=10;
		int[][] tab=Read.field(s);
		int la=tab[0].length;
		System.out.println(la+" ");
		xMin=la*3;
		yMin=la*3;
		tavola=new int[la*3][la*3];

		for (int i=0;i<tab.length;i++) {
			for (int h=0;h<tab[i].length;h++) {
				if (tab[i][h]==9) {
					int[] elfo= {i+la,h+la,0,0,0,0};
					elfi.add(elfo);
					tavola[i+la][h+la]=tab[i][h];
				}
			}
		}

		for (int i=0;i<giri;i++) {
			System.out.println("giro= "+i);
			for (int[] elfo:elfi) {
				check(elfo);
			}
			controlla();
			muovi();
		}
		System.out.println("giro 10 ");
		trovaEst();
		System.out.println(Arrays.toString(elfi.get(0)));
		fin=conta();
		return (long) fin;
	}
	
	static void check(int[] elfo) {
		int[] temp= {elfo[0],elfo[1],elfo[2],0,0,0};
		elfo[5]=0;
		elfo[2]=elfo[2]+1;
		for (int i=0;i<4;i++) {	
			if (temp[2]%4==0) {// NORD
				if (tavola[temp[0]-1][temp[1]]==9||tavola[temp[0]-1][temp[1]-1]==9||tavola[temp[0]-1][temp[1]+1]==9) {
					temp[2]=temp[2]+1;
					temp[5]=1;
					if (temp[3]!=0&&temp[4]!=0) {
						elfo[3]=temp[3]; // cambia
						elfo[4]=temp[4];	// cambia
						elfo[5]=1;
						break;
					}
				}
				else {
					if (temp[5]==1) {
						elfo[3]=temp[0]-1; // cambia
						elfo[4]=temp[1];	// cambia
						elfo[5]=1;
						break;
					}
					else if(temp[3]==0&&temp[4]==0){
						temp[3]=temp[0]-1;	//cambia
						temp[4]=temp[1];	// cambia
						temp[2]=temp[2]+1;
					}
					else {temp[2]=temp[2]+1;  
					}
				}
			}
			else if (temp[2]%4==1) {	// SUD
				if (tavola[temp[0]+1][temp[1]]==9||tavola[temp[0]+1][temp[1]-1]==9||tavola[temp[0]+1][temp[1]+1]==9) {
					temp[2]=temp[2]+1;
					temp[5]=1;
					if (temp[3]!=0&&temp[4]!=0) {
						elfo[3]=temp[3]; // cambia
						elfo[4]=temp[4];	// cambia
						elfo[5]=1;
						break;
					}
				}
				else {
					if (temp[5]==1) {
						elfo[3]=temp[0]+1; // cambia
						elfo[4]=temp[1];	// cambia
						elfo[5]=1;
						break;
					}
					else  if(temp[3]==0&&temp[4]==0){
						temp[3]=temp[0]+1;	//cambia
						temp[4]=temp[1];	// cambia
						temp[2]=temp[2]+1;
					}
					else {temp[2]=temp[2]+1; 
					}
				}
			}
			else if (temp[2]%4==2) {	// OVEST
				if (tavola[temp[0]][temp[1]-1]==9||tavola[temp[0]+1][temp[1]-1]==9||tavola[temp[0]-1][temp[1]-1]==9) {
					temp[2]=temp[2]+1;
					temp[5]=1;
					if (temp[3]!=0&&temp[4]!=0) {
						elfo[3]=temp[3]; // cambia
						elfo[4]=temp[4];	// cambia
						elfo[5]=1;
						break;
					}
				}
				else {
					if (temp[5]==1) {
						elfo[3]=temp[0]; // cambia
						elfo[4]=temp[1]-1;	// cambia
						elfo[5]=1;
						break;
					}
					else  if(temp[3]==0&&temp[4]==0){
						temp[3]=temp[0];	//cambia
						temp[4]=temp[1]-1;	// cambia
						temp[2]=temp[2]+1;
					}
					else {temp[2]=temp[2]+1;
					}
				}
			}
			else if (temp[2]%4==3) {	// EST
				if (tavola[temp[0]][temp[1]+1]==9||tavola[temp[0]+1][temp[1]+1]==9||tavola[temp[0]-1][temp[1]+1]==9) {
					temp[2]=temp[2]+1;
					temp[5]=1;
					if (temp[3]!=0&&temp[4]!=0) {
						elfo[3]=temp[3]; // cambia
						elfo[4]=temp[4];	// cambia
						elfo[5]=1;
						break;
					}
				}
				else {
					if (temp[5]==1) {
						elfo[3]=temp[0]; // cambia
						elfo[4]=temp[1]+1;	// cambia
						elfo[5]=1;
						break;
					}
					else  if(temp[3]==0&&temp[4]==0){
						temp[3]=temp[0];	//cambia
						temp[4]=temp[1]+1;	// cambia
						temp[2]=temp[2]+1;
					}
					else {temp[2]=temp[2]+1; 
					}
				}
			}
		}
	}

	static void controlla() {
		for (int i=0;i<elfi.size();i++) {
			for (int h=0;h<elfi.size();h++){
				if (h!=i&&elfi.get(h)[5]==1&&elfi.get(i)[5]==1) {
					if (elfi.get(i)[3]==elfi.get(h)[3]&&elfi.get(i)[4]==elfi.get(h)[4]) {
						elfi.get(h)[5]=0;
						elfi.get(i)[5]=0;
					}
				}
			}
		}
	}

	static void muovi() {
		clean();
		for (int[] elfo:elfi) {
			if (elfo[5]==1) {
				elfo[0]=elfo[3];
				elfo[1]=elfo[4];
				elfo[3]=0;
				elfo[4]=0;
				elfo[5]=0;
			}
			else {
				elfo[3]=0;
				elfo[4]=0;
			}
			tavola[elfo[0]][elfo[1]]=9;
		}
		
	}
	
	static void clean() {
		for (int i=0;i<tavola.length;i++) {
			for (int h=0;h<tavola[i].length;h++) {
				tavola[i][h]=0;
			}
		}
	}
	
	static void trovaEst() {
		xMas=0;
		yMas=0;
		xMin=100000;
		yMin=100000;
		for (int[] elfo:elfi) {
			if (elfo[0]<yMin) {
				yMin=elfo[0];
			}
			if (elfo[0]>yMas) {
				yMas=elfo[0];
			}
			if (elfo[1]<xMin) {
				xMin=elfo[1];
			}
			if (elfo[1]>xMas) {
				xMas=elfo[1];
			}
		}
	}
	
	static int conta() {
		int cont=0;
		for (int i=yMin;i<=yMas;i++) {
			for (int h=xMin;h<=xMas;h++) {
				if (tavola[i][h]==0) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	
	public static long calculate2(String s) {
		Show ss=new Show("Please waith, this should take an average of 20 seconds...");
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
	
	static public long calc(String s) {
		int giri=0;
		int[][] tab=Read.field(s);
		int la=tab[0].length;
		xMin=la*3;
		yMin=la*3;
		tavola=new int[la*3][la*3];
		
		for (int i=0;i<tab.length;i++) {
			for (int h=0;h<tab[i].length;h++) {
				if (tab[i][h]==9) {
					int[] elfo= {i+la,h+la,0,0,0,0};
					elfi.add(elfo);
					tavola[i+la][h+la]=tab[i][h];
				}
			}
		}
		
		boolean tr=true;
		while (tr) {
			for (int[] elfo:elfi) {
				check(elfo);
			}
			controlla();
			tr=muoviT();
			giri++;
		}
		trovaEst();
		return (long) giri;
	}
	
	static boolean muoviT() {
		clean();
		int moves=0;
		for (int[] elfo:elfi) {
			if (elfo[5]==1) {
				elfo[0]=elfo[3];
				elfo[1]=elfo[4];
				elfo[3]=0;
				elfo[4]=0;
				elfo[5]=0;
				moves++;
			}
			else {
				elfo[3]=0;
				elfo[4]=0;
			}
			tavola[elfo[0]][elfo[1]]=9;
		}
		if (moves==0) {
			return false;
		}
		return true;
	}
}
