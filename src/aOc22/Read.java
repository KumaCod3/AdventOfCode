package aOc22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Read {
	ArrayList<String> input=new ArrayList<String>();
	Scanner sc=new Scanner(System.in);
	ArrayList<String[]> fin=new ArrayList<String[]>();
	
	public Read(String cut) {
		leggi();
		traduci(cut);
	}
	
	public void leggi() {
		String line=sc.nextLine();
		while (!line.equals("stop")){
			input.add(line);
		}
	}
	public void traduci(String cut) {
		for (String lin:input){
			String[] og=lin.split(cut);
			fin.add(og);
			
		}
	}
	public ArrayList<String[]> get() {
		return fin;
	}
	
	//splitta coppia stringa valore
	public static ArrayList<String[]> copList(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			a=a.replace("-"," ");
			String[] riga=a.split(" ");
			lista.add(riga);
		}
		return lista;
	}

	//splitta singoli int a capo
	public static ArrayList<Integer> intList(String s){
		ArrayList<Integer> lista= new ArrayList<Integer>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			int n=Integer.parseInt(a);
			lista.add(n);
		}
		return lista;
	}
	
	//splitta singole Stringhe a capo
		public static LinkedList<int[]> intCopList(String s){
			LinkedList<int[]> lista = new LinkedList<int[]>();
			String[] cut=s.split("\\n");
			for (String line:cut) {
				int[] coor = new int[4];
				line = line.replaceAll(",", " ");
				line = line.replaceAll(" -> ", " ");
				String[] y = line.split(" ");
				for (int d = 0; d < y.length; d++) {
					coor[d] = Integer.parseInt(y[d]);
				}
				lista.add(coor);
			}
			return lista;
		}
		
	//splitta singole Stringhe a capo
	public static List<String> striList(String s){
		ArrayList<String> lista= new ArrayList<String>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			lista.add(a);
		}
		return lista;
	}
	//splitta array di int a capo
	public static List<int[]> intArList(String s){
		List<int[]> lis= new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			String[] riga=a.split("");
			int[] in=new int[riga.length];
			for (int i=0;i<riga.length;i++) {
				in[i]=Integer.parseInt(riga[i]);
			}
			lis.add(in);
		}
		return lis;
	}
	public static int[][] arOfAr(String s){
		String[] cut=s.split("\\n");
		int[][] lis=new int[cut.length][];
		for (int i=0;i<cut.length;i++) {
			String[] riga=cut[i].split("");
			int[] in=new int[riga.length];
			for (int h=0;h<riga.length;h++) {
				in[h]=Integer.parseInt(riga[h]);
			}
			lis[i]=(in);
		}
		return lis;
	}
	//splitta singoli int Virg
	public static List<Integer> intVirList(String s){
		List<Integer> lista= new LinkedList<Integer>();
		String[] cut=s.split(",");
		for (String a:cut) {
			int n=Integer.parseInt(a);
			lista.add(n);
		}
		return lista;
	}
	//coordinate
	public static ArrayList<String[]> coorList(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			a=a.replace("-"," ");
			String[] riga=a.split(" ");
			lista.add(riga);
		}
		return lista;
	}
	
// comandi 22
	public static LinkedList<int[]> comandi(String s,int n){
		LinkedList<int[]> lista= new LinkedList<int[]>();
		String[] cut=s.split("\\n");
		int max=n;
		int min=0-n;
		
		for (String line:cut) {
			line = line.replaceAll(",", " ");
			line = line.replaceAll("\\.\\.", " ");
			line = line.replaceAll("=", " ");
			line = line.replaceAll(" x ", " ");
			line = line.replaceAll(" y ", " ");
			line = line.replaceAll(" z ", " ");
			String[] y = line.split(" ");
			boolean range=true;
	
			int[] riga = new int[y.length];
			for (int i = 0; i < y.length; i++) {
				if (y[i].equals("on")) {
					riga[i] = 1;
				} else if (y[i].equals("off")) {
					riga[i] = 0;
				} else {
					riga[i] = Integer.valueOf(y[i]);
					if (Integer.valueOf(y[i])<min||Integer.valueOf(y[i])>max) {
						range=false;
					}
				}
			}
			if (range) {
				lista.add(riga);
			}
		}
		return lista;
	}
	
	public static LinkedList<long[]> comandi(String s){
		LinkedList<long[]> lista= new LinkedList<long[]>();
		String[] cut=s.split("\\n");
		
		for (String line:cut) {
			line = line.replaceAll(",", " ");
			line = line.replaceAll("\\.\\.", " ");
			line = line.replaceAll("=", " ");
			line = line.replaceAll(" x ", " ");
			line = line.replaceAll(" y ", " ");
			line = line.replaceAll(" z ", " ");
			String[] y = line.split(" ");
	
			long[] riga = new long[y.length];
			for (int i = 0; i < y.length; i++) {
				if (y[i].equals("on")) {
					riga[i] = 1;
				} else if (y[i].equals("off")) {
					riga[i] = 0;
				} else {
					riga[i] = Long.valueOf(y[i])+Integer.MAX_VALUE;
				}
			}
			lista.add(riga);
		}
		return lista;
	}

	public static LinkedList<int[]> coor(String s){
		LinkedList<int[]> lista= new LinkedList<int[]>();
		String[] cut=s.split("\\n");
		for (String cor:cut) {
			int[] ins=new int[2];
			String[] sing=cor.split(",");
			ins[0]=Integer.parseInt(sing[0]);
			ins[1]=Integer.parseInt(sing[1]);
			lista.add(ins);
		}
		
		return lista;
	}
			
			
	public static ArrayList<int[]> simb(String s) {
		ArrayList<int[]> tavola=new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String a:cut){
			String[] y=a.split("");
			int[] x=new int[y.length];
			for (int d=0;d<y.length;d++){
				if (y[d].equals(".")){
					x[d]=0;}
				else if (y[d].equals(">")){
					x[d]=1;}
				else if (y[d].equals("v")){
					x[d]=2;}
				}
			tavola.add(x);
			}
		return tavola;
	}
	public static ArrayList<String[]> pieg(String s){
		ArrayList<String[]> pieghe = new ArrayList<String[]>();
		
		String[] ele=s.split("\\n");
		for (String inn:ele) {
			String[] intera = inn.split(" ");
			String[] pieg = intera[2].split("=");
			pieghe.add(pieg);
		}
		
		return pieghe;
	}
	
	public static HashMap<String, String> rule(String s){
		HashMap<String, String> rules = new HashMap<String, String>();
		String[] cut=s.split("\\n");
		for (String line:cut) {
			if (line.equals("")) {
				continue;
			}
	
			line = line.replaceAll("\\-\\>", "");
			String[] y = line.split("  ");
			rules.put(y[0], y[1]);
		}
		return rules;
	}
	
	public static LinkedList<int[]> inp(String s){
		LinkedList<int[]> input = new LinkedList<int[]>();
		String[] cut=s.split("\\n");
		for (String line:cut) {
			
			if (line.equals("")) {
				continue;
			}
		
			String[] y = line.split("");
			int[] lin = new int[y.length];
			for (int d = 0; d < y.length; d++) {
				if (y[d].equals("#")) {
					lin[d] = 1;
				}
			}
		input.add(lin);
		}
		return input;
	}
	
}
