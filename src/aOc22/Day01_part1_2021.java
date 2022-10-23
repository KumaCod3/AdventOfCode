package aOc22;

import java.util.ArrayList;

public class Day01_part1_2021 {
	private static long ris;
	
	public static long calculate(String s) {
		ArrayList<Integer> lista = Read.intList(s);
		int fin=0;
		for (int i = 0; i < lista.size() - 1; i++) {
			if (lista.get(i) < lista.get(i + 1)) {
				fin = fin + 1;
			}
		}
		
		
		return (long) fin;
	}
}
