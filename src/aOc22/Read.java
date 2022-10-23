package aOc22;

import java.util.ArrayList;
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
	
	//splitta singoli int a capo
	public static ArrayList<String[]> copList(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
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
}
