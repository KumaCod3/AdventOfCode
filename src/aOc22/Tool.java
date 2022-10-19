package aOc22;

import java.awt.Toolkit;
import java.util.ArrayList;

public class Tool {
	
	// DING DONG DANG
	public static void bell() {
		Toolkit.getDefaultToolkit().beep();
	}
	// DA BINARIO A DECIMALE
	public static int binToDec(String a){
		String[] u=a.split("");
		int[] w=new int[u.length];
		for (int i=0;i<w.length;i++){
			w[i]=Integer.parseInt(u[i]);
		}
		int[] bib=new int[w.length];
		for (int i=0;i<w.length;i++){
			bib[w.length-1-i]=(int)Math.pow(2, i);
		}
		int val=0;
		for(int g=0;g<w.length;g++) {
			val=val+(w[g]*bib[g]);
			}
		return val;
	}
	public static int binToDec(int[] w){
		int l=w.length;
		int[] bin = new int[l];
		for (int i=0;i<l;i++){
			bin[l-1-i]=(int)Math.pow(2, i);
		}
		int val=0;
		for(int g=0;g<l;g++) {
			val=val+(w[g]*bin[g]);
			}
		return val;
	}
	// DA DECIMALE A BINARIO
	public static String decToBin(int a){
		String fin="";
		while (a>0) {
			int bin=a%2;
			fin=bin+fin;
			a=a/2;
		}
		
		return fin;
	}

	// RICERCA SE PAROLA C'È
	public boolean search(String[] v, String e){
		for (int i=0;i<v.length;i++){
			if (v[1].equals(e)){
				return true;
			}
		}
		return false;
	}
	
	// TROVA IL NUMERO MASSIMO 
	public int massimo(int[] v){
		int max=0;
		for (int i=0;i<v.length;i++){
			if (v[i]>max){
				max=v[i];
			}
		}
		return max;
	}
	// TROVA IL NUMERO MINIMO
	public int minimo(int[] v){
		int max=0;
		for (int i=0;i<v.length;i++){
			if (v[i]<max){
				max=v[i];
			}
		}
		return max;
	}
	
	// STAMPA ALTERNATA
	public void stampa(int[] v){
		for (int i=0;i<v.length/2;i++){
			System.out.println(v[i]);
			System.out.println(v[v.length-1-i]);
		}
	}
	
	//PARI E DISPARI
	public boolean pardis(int[] v){
		int pari=0;
		int dispari=0;
		for (int i=0;i<v.length;i++){
			if (i%2==0){
				pari=pari+v[i];
			}
			else {
				dispari=dispari+v[i];
			}
		}
		if (pari==dispari){
			return true;
		}
		else
			return false;
	}
	
	// DUE ARRAY
	public int[] dueAr(int[] v){
		int conta=0;
		
		for (int i=0;i<v.length;i++){
			if (v[i]>=0){
				conta++;
			}
		}
		int[] c=new int[conta];
		int u=0;
		for (int h=0;h<conta;h++){
			for (int i=u;i<v.length;i++){
				if (v[i]>=0){
					c[conta-1-h]=v[i];
					u=i+1;
					break;
				}
			}
		}
		return c;
	}
		
	// TRE CONSECUTIVI =
	public boolean treUg(int[] v){
		for (int i=0;i<v.length-2;i++){
			if(v[i]==v[i+1]&&v[i+2]==v[i+1]){
				return true;
			}
		}
		return false;
	}
	
	// UNO DOPPIO DI ALTRO
	public boolean ilDoppio(int[] v){
		for (int i=0;i<v.length;i++){
			for (int h=0;h<v.length;h++){
				if(v[i]==2*v[h]){
					System.out.println(v[i]+" e la meta di "+v[h]);
					return true;
				}
			}
		}
		return false;
		
	}
	// COMPARA STRINGHE[]
	public boolean dueStringhe(String[] v,String[] w){
		for (int i=0;i<v.length;i++){
			for (int h=0;h<w.length;h++){
				if(v[i].equals(w[h])){
					System.out.println(v[i]+" e uguale a "+w[h]);
					return true;
				}
			}
		}
		return false;
		
	}
	// LA PAROLA CE?
	public static boolean check(ArrayList<String> d, String z){
		boolean ck=true;
		for (String a:d){
			if (a.equals(z)){
				ck=false;
			}
		}
		return ck;
	}
}
