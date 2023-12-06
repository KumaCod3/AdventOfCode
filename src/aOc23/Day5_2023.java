package aOc23;
import java.util.ArrayList;
import program.Read;

public class Day5_2023 {
	private static ArrayList<Long[][]> mappe =new ArrayList<Long[][]>();
	private static ArrayList<Long[]> intervals=new ArrayList<Long[]>();
	
	public static long calculate1(String s) {
		ArrayList<String[]> lista = Read.monk(s);

		String[] a=lista.get(0)[0].split(":")[1].trim().split(" ");
		Long[] seeds=new Long[a.length];
		for (int i=0;i<a.length;i++) {
			seeds[i]=Long.parseLong(a[i]);
		}
		for (int i=1;i<lista.size();i++) {
			String[] aa=lista.get(i);
			Long[][] mappa=new Long[aa.length-1][];
			for (int j=1;j<aa.length;j++) {
				String[] corpar=aa[j].split(" ");
				Long[] coor= {Long.parseLong(corpar[0]),Long.parseLong(corpar[1]),Long.parseLong(corpar[2])};
				mappa[j-1]=coor;
			}
			mappe.add(mappa);
		}
		
		for (int n=0;n<seeds.length;n++) {
			for (int i=0; i<mappe.size();i++) {
				System.out.println("prima "+seeds[n]);
				seeds[n]=converti(seeds[n],i);
				System.out.println("dopo "+seeds[n]);
			}
		}
		Long fin=999999999999999l;
		for (int n=0;n<seeds.length;n++) {
			if (fin>seeds[n]) {
				fin=seeds[n];
			}
		}
		return fin;
	}
	
	private static Long converti(Long n, int indMappa) {
		Long[][] map=mappe.get(indMappa);
		for (Long[] cor:map) {
			Long dif=n-cor[1];
			if (n>=cor[1]&&dif<cor[2]) {
				return cor[0]+dif;
			}
		}
		return n;
	}
	
	public static long calculate2(String s) {
		ArrayList<String[]> lista = Read.monk(s);
		String[] a=lista.get(0)[0].split(":")[1].trim().split(" ");
		Long[] seeds=new Long[a.length];
		Long fin=0l;
		
		for (int i=0;i<a.length;i++) {
			seeds[i]=Long.parseLong(a[i]);
		}
		for (int i=0;i<seeds.length-1;i=i+2) {
			Long[] coppia= {seeds[i],seeds[i]+seeds[i+1]};
			intervals.add(coppia);
		}
		
//		parso le mappe
		for (int i=1;i<lista.size();i++) {
			String[] aa=lista.get(i);
			Long[][] mappa=new Long[aa.length-1][];
			for (int j=1;j<aa.length;j++) {
				String[] corpar=aa[j].split(" ");
				Long[] coor= {Long.parseLong(corpar[0]),Long.parseLong(corpar[1]),Long.parseLong(corpar[2])};
				mappa[j-1]=coor;
			}
			mappe.add(mappa);
		}
		int conversioni=mappe.size();

		for (fin=0l;fin<Long.MAX_VALUE;fin++) {
			long prova=fin;
			for (int i=conversioni-1;i>=0;i--) {
				prova=noctrevi(prova,i);
			}
			if (compreso(prova)) {
				return fin;
			}
		}
		
		return fin;
	}
	
	private static Long noctrevi(Long n, int indMappa) {
		Long[][] map=mappe.get(indMappa);
		for (Long[] cor:map) {
			Long dif=n-cor[0];
			if (n>=cor[0]&&dif<cor[2]) {
				return cor[1]+dif;
			}
		}
		return n;
	}
	
	private static boolean compreso(Long prova) {
		for (Long[] rang:intervals) {
			if (prova>=rang[0]&&prova<=rang[1]) {
				return true;
			}
		}
		return false;
	}
}
