package aOc23;
import java.util.ArrayList;
import java.util.Arrays;
import program.Read;

public class Day4_2023 {
	static ArrayList<Integer> res1= new ArrayList<Integer>();
	static int[] carte;
	
	public static long calculate1(String s) {
		ArrayList<String[]> lista = Read.copList23(s);
		ArrayList<Integer> res= new ArrayList<Integer>();
		
		for (String[] riga:lista) {
			riga[0]=riga[0].trim();
			riga[0]=riga[0].replace("  "," ");
			riga[1]=riga[1].trim();
			riga[1]=riga[1].replace("  "," ");
			System.out.println(Arrays.toString(riga));
			String[] win=riga[0].split(" ");
			String[] miei=riga[1].split(" ");
			int vinti=0;
			for (String ss:win) {
				for (String sa:miei) {
					if (ss.equals(sa)) {
						System.out.println(sa+" = "+ss);
						vinti++;
						break;
					}
				}
			}
			if(vinti>0) {
				res.add(vinti);
			}
		}
		double fin=0;
		for (int n:res) {
			System.out.println(n);
			int el=n-1;
			double pw=Math.pow(2, el);
			fin=fin+pw;
		}
		
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		ArrayList<String[]> lista = Read.copList23(s);
		int fin=0;
		ArrayList<Integer> res2= new ArrayList<Integer>();
		carte=new int[lista.size()+1];
		fin=lista.size();
		for (int i=0;i<lista.size();i++) {
			lista.get(i)[0]=lista.get(i)[0].trim();
			lista.get(i)[0]=lista.get(i)[0].replace("  "," ");
			lista.get(i)[1]=lista.get(i)[1].trim();
			lista.get(i)[1]=lista.get(i)[1].replace("  "," ");
			String[] win=lista.get(i)[0].split(" ");
			String[] miei=lista.get(i)[1].split(" ");
			int vinti=0;
			for (String ss:win) {
				for (String sa:miei) {
					if (ss.equals(sa)) {
						vinti++;
						break;
					}
				}
			}
			carte[i+1]=vinti;
		}
		for (int i=1;i<carte.length;i++){
			if (carte[i]>0) {
				res1.add(i);
			}
		}
		
		boolean fermo=false;
		while (fermo==false) {
			for (int i=0;i<res1.size();i++){
				int indice=res1.get(i);
				if (carte[indice]>0) {
					for (int j=1;j<=carte[indice];j++) {
						res2.add(indice+j);
						fin++;
					}
				}
			}
			res1.clear();
			fermo=controlla(res2);
			res2.clear();
		}
		return (long) fin;
	}
	
	static boolean controlla(ArrayList<Integer> res2) {
		boolean r=true;
		for (Integer n:res2) {
			res1.add(n);
			if (carte[n]>0) {
				r = false;
			}
		}
		return r;
	}
}