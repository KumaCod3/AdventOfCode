package aOc22;

import java.util.ArrayList;
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
		ArrayList<String> lista= new ArrayList<String>();
		List<int[]> lis= new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			lista.add(a);
		}
		for (String a:lista) {
			String[] riga=a.split("");
			int[] in=new int[riga.length];
			for (int i=0;i<riga.length;i++) {
				in[i]=Integer.parseInt(riga[i]);
			}
			lis.add(in);
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
}
