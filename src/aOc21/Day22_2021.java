package aOc21;
import program.Nope;
import program.Read;

public class Day22_2021 {
//	private static LinkedList<long[]> com=new LinkedList<long[]>();
//	private static HashMap<ArrayList<Long>,Boolean> on=new HashMap<ArrayList<Long>,Boolean>();
	
	public static long calculate1(String s) {
		var comandi=Read.comandi(s,50);
		var cubo = new int[110][110][110];
		int ris=0;
		
		for (int[] i : comandi) {
			for (int x = i[1] + 51; x <= i[2] + 51; x++) {
				for (int y = i[3] + 51; y <= i[4] + 51; y++) {
					for (int z = i[5] + 51; z <= i[6] + 51; z++) {
						cubo[x][y][z] = i[0];
					}
				}
			}
		}

// count lit points
		for (int x = 0; x < cubo.length; x++) {
			for (int y = 0; y < cubo[0].length; y++) {
				for (int z = 0; z < cubo[0][0].length; z++) {
					if (cubo[x][y][z] == 1) {
						ris = ris + 1;
					}
				}
			}
		}
		return (long) ris;
	}
	
	public static long calculate2(String s) {
		int fin=0;
		
		Nope no=new Nope();
		no.setVisible(true);
		
		return (long) fin;
		
		/*
		com.clear();
		com=Read.comandi(s);
		var isolati=new LinkedList<long[]>();
		var sovrapposti=new LinkedList<long[]>();
		on.clear();
		int giro=0;
		long somma=0;
		
// TROVA SOLO INTESEZIONI E RENDILE NEGATIVE POI SOMMA E SOTTRAI TUTTI...		
		
		// metti in nuovo comandi tutti quelli che non si intersecano mai!
		// e in un altro quelli che si intersecano
		for (int i=0;i<com.size();i++) {
			boolean tr=true;
			for (int h=0;h<com.size();h++) {
				if (h!=i&&interseca(com.get(i),com.get(h))) {
					tr=false;
					break;
				}
			}
			if (tr==false) {
				System.out.println("sovrappone:"+Arrays.toString(com.get(i)));
				sovrapposti.add(com.get(i));
			}
			else if (com.get(i)[0]==1){
				System.out.println("---isolato:"+Arrays.toString(com.get(i)));
				isolati.add(com.get(i));
			}
			else {
				System.out.println("-----butto:"+Arrays.toString(com.get(i)));
			}
		}
		System.out.println("tot:"+com.size()+" sovr="+sovrapposti.size()+" isolati:"+isolati.size());
		
		// fai calcolo su intersecano
		for (long[] i : sovrapposti) {
			giro++;
			System.out.println("giro "+giro+" su "+sovrapposti.size());
			if (i[0]==1) {
				System.out.println("agg");
				for (long x = i[1]; x <= i[2]; x++) {
					for (long y = i[3]; y <= i[4]; y++) {
						for (long z = i[5]; z <= i[6]; z++) {
							
							ArrayList<Long> tt= new ArrayList<Long>();
							tt.add(x);
							tt.add(y);
							tt.add(z);
							on.put(tt,true);
						}
					}
				}
			}
			else if (i[0]==0) {
				System.out.println("tolg");
				for (long x = i[1]; x <= i[2]; x++) {
					for (long y = i[3]; y <= i[4]; y++) {
						for (long z = i[5]; z <= i[6]; z++) {
							ArrayList<Long> tt= new ArrayList<Long>();
							tt.add(x);
							tt.add(y);
							tt.add(z);
							on.put(tt,false);
						}
					}
				}
			}
		}
		
		for (boolean b:on.values()) {
			if (b) {
				somma++;
			}
		}
		System.out.println("fin 1 "+somma);
		// fai conteggio di non intersecano
		for (long[] i : isolati) {
			for (long x = i[1]; x <= i[2]; x++) {
				for (long y = i[3]; y <= i[4]; y++) {
					for (long z = i[5]; z <= i[6]; z++) {
						somma++;
					}
				}
			}
		}
		
		return somma;
	}

	private static boolean interseca(long[] a, long[] b) {
		boolean x=false;
		boolean y=false;
		boolean z=false;
		if (a[1]<=b[1]&&a[2]>=b[2]||a[1]>=b[1]&&a[2]<=b[2]||a[1]<=b[2]&&a[2]>=b[2]||a[1]<=b[1]&&a[2]>=b[1]) {
			x=true;
		}
		if (a[3]<=b[3]&&a[4]>=b[4]||a[3]>=b[3]&&a[4]<=b[4]||a[3]<=b[4]&&a[4]>=b[4]||a[3]<=b[3]&&a[4]>=b[3]) {
			y=true;
		}
		if (a[5]<=b[5]&&a[6]>=b[6]||a[5]>=b[5]&&a[6]<=b[6]||a[5]<=b[6]&&a[6]>=b[6]||a[5]<=b[5]&&a[6]>=b[5]) {
			z=true;
		}
		return (x&&y&&z);
		
		*/
	}
	
}
