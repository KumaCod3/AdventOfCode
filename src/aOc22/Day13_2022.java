package aOc22;

import java.util.ArrayList;
import program.Read;

public class Day13_2022 {
	static ArrayList<Lista13> lista;
	static ArrayList<Lista13> canc;
	static int[] ii= {-1,-1,2,-2,-2};
	static int[] hh= {-1,-1,6,-2,-2};
	
	public static long calculate1(String s) {
		int fin=0;
		ArrayList<String[]> list = Read.monk(s);
		ArrayList<Lista13[]> listaaa =new ArrayList<Lista13[]>();
		for (String[] cop:list) {
			Lista13[] temp=new Lista13[2];
			for (int h=0;h<2;h++) {
				String line=cop[h];
				line=line.replace("[", " [ ");
				line=line.replace("]", " ] ");
				line=line.replace(",", " ");
				line=line.replace("  ", " ");
				line=line.replace("  ", " ");
				line=line.trim();
				line=line.replace("[", "-1");
				line=line.replace("]", "-2");
				String[] riga=line.split(" ");
				int[] rInt=new int[riga.length];
				for (int i=0;i<riga.length;i++) {
					rInt[i]=Integer.parseInt(riga[i]);
				}
				Lista13 tt=new Lista13(rInt,0);
				temp[h]=tt;
			}
			listaaa.add(temp);
		}
		
		for (int i=0; i<listaaa.size();i++) {
			Lista13[] temp=listaaa.get(i);
			try {
				if (controllo(temp)) {
					System.out.println("vero "+(i+1));
					fin=fin+i+1;
				}
				else {
					System.out.println("FALSO");
				}
			}
			catch (Exception e) {System.out.println("Liste =! ");}
		}
		return (long) fin;
	}

	public static long calculate2(String s) {
		int fin=0;
		ArrayList<String[]> list = Read.monk(s);
		lista =new ArrayList<Lista13>();
		for (String[] cop:list) {
			for (int h=0;h<2;h++) {
				String line=cop[h];
				line=line.replace("[", " [ ");
				line=line.replace("]", " ] ");
				line=line.replace(",", " ");
				line=line.replace("  ", " ");
				line=line.replace("  ", " ");
				line=line.trim();
				line=line.replace("[", "-1");
				line=line.replace("]", "-2");
				String[] riga=line.split(" ");
				int[] rInt=new int[riga.length];
				for (int i=0;i<riga.length;i++) {
					rInt[i]=Integer.parseInt(riga[i]);
				}
				Lista13 tt=new Lista13(rInt,0);
				lista.add(tt);
			}
		}
		
		doIt();
		
		int sei=0;
		int due=0;
		for (int i=0;i<canc.size();i++) {
			System.out.println("fin: "+canc.get(i));
			if (canc.get(i).equals(ii)) {
				due=i;
			}
			if (canc.get(i).equals(hh)) {
				sei=i;
			}
		}
		System.out.println(due+" x "+sei);
		fin=(1+due)*(1+sei);

		return (long) fin;
	}

	private static void doIt() {
		canc=new ArrayList<Lista13>();
		Lista13 aa=new Lista13(ii,0);
		Lista13 bb=new Lista13(hh,0);
		canc.add(aa);
		canc.add(bb);
		boolean tr=true;
		for (Lista13 ll:lista){
			tr=true;
			for (int i=0;i<canc.size();i++){
				  Lista13[] temp={ll,canc.get(i)};
				  try {
					    if (controllo(temp)){
					    	canc.add(i,ll);
					    	tr=false;
					      break;
					    }
					    else {
					    	continue;
					    }
				  }
				  catch (Exception e) {}
			}
			if (tr) {
				canc.add(ll);
			}
		}
	}

	private static boolean controllo(Lista13[] temp) throws Exception {
		Lista13 a=temp[0];
		Lista13 b=temp[1];
		int lungA=a.lista.size();
		int lungB=b.lista.size();
		int lungM;
		if (lungA>lungB) {
			lungM=lungB;
		}
		else {
			lungM=lungA;
		}
		for (int i=0;i<lungM;i++) {
			Object aa=a.lista.get(i);
			Object bb=b.lista.get(i);
			if (aa instanceof Integer && bb instanceof Integer) {
				if ((int)bb>(int)aa) {
					System.out.println(i+" numeri VERO "+bb+" mag di "+aa);
					return true;
				}
				else if ((int)bb<(int)aa) {
					System.out.println(i+" numeri FALSO "+bb+" min di "+aa);
					return false;
				}
				else {
					System.out.println(i+" numeri UGUALI continuo "+bb+" = "+aa);
					continue;
				}
			}
			else if (aa instanceof Lista13 && bb instanceof Lista13) {
				Lista13[] tett= {(Lista13)aa,(Lista13)bb};
				try {
					return controllo(tett);
				}
				catch (Exception e) {continue;}
			}
			else if (aa instanceof Lista13) {
				Lista13 tt=new Lista13((Integer)bb);
				Lista13[] tett= {(Lista13)aa,tt};
				try {
					return controllo(tett);
				}
				catch (Exception e) {continue;}
			}
			else if (bb instanceof Lista13) {
				Lista13 tt=new Lista13((Integer)aa);
				Lista13[] tett= {tt,(Lista13)bb};
				try {
					return controllo(tett);
				}
				catch (Exception e) {continue;}
			}
		}
		if (lungB!=lungA) {
			System.out.println("lunghezza "+(lungB>lungA));
			return (lungB>lungA);
		}
		
		System.out.println("Passato oltre");
		throw (new Exception());
	}
}
