package aOc21;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import program.Read;
import program.Tool;

public class Day3_2021 {
	public static long calculate1(String s) {
		List<String> lista = Read.striList(s);
		int fin=0;
		int tot = 0;
		int[] arr = new int[12];
		int[] gamma = new int[12];
		int[] epsilon = new int[12];
		int gam = 0;
		int eps = 0;
		
		for (String a:lista) {
			String[] numbers = a.split("");
			for (int i = 0; i < 12; i++) {
				arr[i] = arr[i] + Integer.valueOf(numbers[i]);
				tot++;
			}
		}
		for (int h = 0; h < 12; h++) {
			if (arr[h] > (tot / 24)) {
				gamma[h] = 1;
			} else {
				epsilon[h] = 1;
			}
		}
		gam=Tool.binToDec(gamma);
		eps=Tool.binToDec(epsilon);
		fin = gam * eps;
		
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		List<int[]> lista= Read.intArList(s);
		int fin=0;
		int t = 2;
		int o2 = 0;
		int co2 = 0;
		int ripO = 0;
		int ripC = 0;
//		int[] bin = { 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 };
		ArrayList<int[]> listaO = new ArrayList<int[]>();
		ArrayList<int[]> temp = new ArrayList<int[]>();
		ArrayList<int[]> listaC = new ArrayList<int[]>();
		
		
		// make copy for Oxigen & for Anid
				for (int[] i : lista) {
					listaO.add(i);
				}
				for (int[] i : lista) {
					listaC.add(i);
				}

		// calc. OXY binary
				int[] oxy = new int[lista.get(0).length];

				while (t == 2) {
					for (int q = 0; q < oxy.length; q++) {
						oxy[q] = media(listaO, q);
					}

					for (int[] i : listaO) {
						if (i[ripO] == oxy[ripO]) {
							temp.add(i);
						}
					}
	//				System.out.println("OXY val: " + Arrays.toString(oxy));
					listaO.clear();
					for (int[] i : temp) {
						listaO.add(i);
					}
					temp.clear();
					ripO = ripO + 1;
					if (listaO.size() <= 1) {
						t = 3;
						break;
					}
				}

		// calc. ANID binary
				int[] ani = new int[lista.get(0).length];
				while (t == 3) {

					for (int q = 0; q < ani.length; q++) {
						ani[q] = aida(listaC, q);
					}

					for (int[] i : listaC) {
						if (i[ripC] == ani[ripC]) {
							temp.add(i);
						}
					}
					listaC.clear();
					for (int[] i : temp) {
						listaC.add(i);
					}
					temp.clear();
					ripC = ripC + 1;
//					System.out.println(" lista Co2: ");


					if (listaC.size() <= 1) {
						t = 5;
						break;
					}
				}
		// calc. OXY e ANID value
				int[] ossigeno = listaO.get(0);
				int[] anidride = listaC.get(0);
				o2=Tool.binToDec(ossigeno);
				co2=Tool.binToDec(anidride);
				fin = o2 * co2;
//				System.out.println(
//						"rimasto O2: " + Arrays.toString(listaO.get(0)) + " rimasto Co2: " + Arrays.toString(listaC.get(0)));
//				System.out.println("Risultato: " + fin);
				
				
				
				
		
		
		return (long) fin;
	}
	
	// method to find most common (0 or 1)
		public static int media(ArrayList<int[]> x, int y) {
			int zero = 0;
			int uno = 0;
			for (int[] i : x) {
				if (i[y] == 0) {
					zero = zero + 1;
				} else if (i[y] == 1) {
					uno = uno + 1;
				}
			}
			if (zero > uno) {
				return 0;
			} else {
				return 1;
			}
		}

	// method to find least common (0 or 1)
		public static int aida(ArrayList<int[]> x, int y) {
			int zero = 0;
			int uno = 0;
			for (int[] i : x) {
				if (i[y] == 0) {
					zero = zero + 1;
				} else if (i[y] == 1) {
					uno = uno + 1;
				}
			}
			if (zero > uno) {
				return 1;
			} else {
				return 0;
			}
		}
		
}
