package aOc22;
import java.util.ArrayList;
import program.Read;
import program.Show;

public class Day10_2022 {
	static int fin=0;
	static int cycle=0;
	static int x=1;
	static int[] tab=new int[241];
	
	public static long calculate1(String s) {
		fin=0;
		ArrayList<String[]> list = Read.copListN(s);
		cycle=0;
		x=1;
		
		for (String[] a:list) {
			System.out.println("Provo: "+a[0]);
			if (a[0].equals("noop")) {
				cycle=cycle+1;
				prova();
			}
			else {
				int y=Integer.parseInt(a[1]);
				cycle=cycle+1;
				prova();
				cycle=cycle+1;
				prova();
				x=x+y;
			}
		}
		
		
		
		return (long) fin;
	}
	
	static void prova(){
		if (cycle%20==0&&(cycle/20)%2==1) {
			System.out.println("fin:  "+x+" * "+cycle);
			fin=fin+(x*cycle);
		}
	}
	
	public static long calculate2(String s) {
		fin=0;
		ArrayList<String[]> list = Read.copListN(s);
		cycle=0;
		x=1;
		char[][] fine=new char[6][];
		
		for (String[] a:list) {
			System.out.println("Provo: "+a[0]);
			if (a[0].equals("noop")) {
				provaB();
				cycle=cycle+1;
				
			}
			else {
				int y=Integer.parseInt(a[1]);
				
				provaB();
				cycle=cycle+1;
				provaB();
				cycle=cycle+1;
				x=x+y;
			}
		}
		
		for (int i=0;i<6;i++) {
			char[] line=new char[40];
			
			for (int h=0;h<40;h++) {
				if (tab[fin]==9) {
					line[h]='$';
				}
				else {
					line[h]='-';
				}
				fin++;
			}
			fine[i]=line;
		}
		
		Show f=new Show(fine);
		f.setVisible(true);
		return (long) fin;
	}
	
	static void provaB(){
		System.out.println("ciclo  "+(cycle-1)+" X= "+x);
		int primo=x-1;
		int secondo=x;
		int terzo=x+1;
		int pos=cycle%40;
		if (primo==pos||secondo==pos||terzo==pos) {
			tab[cycle]=9;
		}
	}
}
