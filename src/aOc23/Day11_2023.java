package aOc23;
import java.util.ArrayList;
import program.Read;

public class Day11_2023 {
	private static ArrayList<char[]> lista;
	private static ArrayList<ArrayList<Character>>lis;
	
	public static long calculate1(String s) {
		lista = Read.copListCh(s);
		int fin=0;
		// espando
		int n=0;
		while (n<lista.size()) {
			n=espandiGiu(n);
			n++;
		}
		lis=new ArrayList<ArrayList<Character>>();
		for (char[] cr:lista) {
			ArrayList<Character> temp=new ArrayList<Character>();
			for (char ch:cr) {
				temp.add(ch);
			}
			lis.add(temp);
		}
		int nn=0;
		while (nn<lis.get(0).size()) {
			nn=espandiLato(nn);
			nn++;
		}
		//trovo coor di galassie
		ArrayList<int[]> galassie=new ArrayList<int[]>();
		for (int x=0;x<lis.size();x++) {
			for (int y=0;y<lis.get(0).size();y++) {
				if (lis.get(x).get(y)=='#') {
					int[] cor= {x,y};
					galassie.add(cor);
				}
			}
		}
		// calcolo distanze
		for (int i=0;i<galassie.size()-1;i++) {
			int[] cor1=galassie.get(i);
			for (int j=i+1;j<galassie.size();j++) {
				int dist=0;
				int[] cor2=galassie.get(j);
				dist=calcolo(cor1,cor2);
				fin=fin+dist;
			}
		}
		return (long) fin;
	}
	
	static int calcolo(int[] a, int[]b) {
		int x=Math.abs(a[0]-b[0]);
		int y=Math.abs(a[1]-b[1]);
		return x+y;
	}
	
 	static int espandiGiu(int n) {
		boolean tr=true;
		for (char ch:lista.get(n)) {
			if (ch=='#') {
				tr=false;
				break;
			}
		}
		if (tr) {
			char[] cr=new char[lista.get(0).length];
			lista.add(n,cr);
			n++;
		}
		return n;
	}
	
	static int espandiLato(int n) {
		boolean tr=true;
		for (ArrayList<Character> cr:lis) {
			char ch=cr.get(n);
			if (ch=='#') {
				tr=false;
				break;
			}
		}
		if (tr) {
			for (ArrayList<Character> cr:lis) {
				cr.add(n,'.');
			}
			n++;
		}
		return n;
	}
	
	public static long calculate2(String s) {
		lista = Read.copListCh(s);
		Long fin=0l;
		ArrayList<Integer> espandGiu =new ArrayList<Integer>();
		ArrayList<Integer> espandLat =new ArrayList<Integer>();
		// espando
		int n=0;
		while (n<lista.size()) {
			int cor=0;
			cor=espandiGiuMega(n);
			if (cor>0) {
				espandGiu.add(cor);
			}
			n++;
		}
		n=0;
		while (n<lista.get(0).length) {
			int cor=0;
			cor=espandiLatMega(n);
			if (cor>0) {
				espandLat.add(cor);
			}
			n++;
		}
		espandGiu.add(lista.size()+1);
		espandLat.add(lista.get(0).length+1);
		
		//trovo coor di galassie
		ArrayList<int[]> galassie=new ArrayList<int[]>();
		
		for (int x=0;x<lista.size();x++) {
			for (int y=0;y<lista.get(0).length;y++) {
				if (lista.get(x)[y]=='#') {
					int[] cor= {x,y};
					galassie.add(cor);
				}
			}
		}
		
		// espando galasseie
		ArrayList<Long[]> galassiEx=new ArrayList<Long[]>();
		for (int[] cor:galassie) {
			Long[] cc=new Long[2];
			cc[0]=(long) cor[0];
			cc[1]=(long) cor[1];
			galassiEx.add(cc);
		}
		
		int min=-1;
		long moltip=1000000l;
		
		for (int i=0;i<espandLat.size();i++) {
			int col=espandLat.get(i);
			for (Long[] cor:galassiEx) {
				if (cor[1]<=col&&cor[1]>min) {
					cor[1]=(cor[1]+(moltip*i))-i;
				}
			}
			min=col;
		}
		min=-1;
		for (int i=0;i<espandGiu.size();i++) {
			int col=espandGiu.get(i);
			for (Long[] cor:galassiEx) {
				if (cor[0]<=col&&cor[0]>min) {
					cor[0]=(cor[0]+(moltip*i))-i;
				}
			}
			min=col;
		}
		
		// calcolo distanze
		for (int i=0;i<galassiEx.size()-1;i++) {
			Long[] cor1=galassiEx.get(i);
			for (int j=i+1;j<galassiEx.size();j++) {
				Long dist=0l;
				Long[] cor2=galassiEx.get(j);
				dist=calcolo(cor1,cor2);
				fin=fin+dist;
			}
		}
		return fin;
	}
	
	private static int espandiGiuMega(int n) {
		for (char ch:lista.get(n)) {
			if (ch=='#') {
				return -1;
			}
		}
		return n;
	}
	
	private static int espandiLatMega(int n) {
		for (char[] cr:lista) {
			char ch=cr[n];
			if (ch=='#') {
				return -1;
			}
		}
		return n;
	}

	static Long calcolo(Long[] a, Long[]b) {
		Long x=Math.abs(a[0]-b[0]);
		Long y=Math.abs(a[1]-b[1]);
		return x+y;
	}
}