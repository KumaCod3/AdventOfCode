package aOc21;

import java.util.ArrayList;

import program.Read;

public class Day1_2021 {
	
	public static long calculate1(String s) {
		ArrayList<Integer> lista = Read.intList(s);
		int fin=0;
		for (int i = 0; i < lista.size() - 1; i++) {
			if (lista.get(i) < lista.get(i + 1)) {
				fin = fin + 1;
			}
		}
		
		return (long) fin;
	}
	public static long calculate2(String s) {
		ArrayList<Integer> lista = Read.intList(s);
		int fin=0;

		for (int i = 0; i < lista.size() - 3; i++) {
			int A = lista.get(i) + lista.get(i + 1) + lista.get(i + 2);
			int B = lista.get(i + 1) + lista.get(i + 2) + lista.get(i + 3);
			if (A < B) {
				fin = fin + 1;
			}
		}
		
		return (long) fin;
	}
}
