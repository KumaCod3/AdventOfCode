package aOc22;
import java.util.ArrayList;
import program.Read;

public class Day01_2022 {
	public static long calculate1(String s) {
		ArrayList<int[]> lista = Read.simp(s);
		int max1=0;
		
		for (int[] a:lista) {
			int somma=0;
			for (int i:a) {
				somma=somma+i;
			}
			if (somma>max1) {
				max1=somma;
			}
		}

		return (long) max1;
	}
	public static long calculate2(String s) {
		int fin=0;
		ArrayList<int[]> lista = Read.simp(s);
		int max1=0;
		int max2=0;
		int max3=0;
		
		for (int[] a:lista) {
			int somma=0;
			for (int i:a) {
				somma=somma+i;
			}
			if (somma>max1) {
				max1=somma;
			}
		}
		for (int[] a:lista) {
			int somma=0;
			for (int i:a) {
				somma=somma+i;
			}
			if (somma>max2&&somma<max1) {
				max2=somma;
			}
		}
		for (int[] a:lista) {
			int somma=0;
			for (int i:a) {
				somma=somma+i;
			}
			if (somma>max3&&somma<max2) {
				max3=somma;
			}
		}
		fin=max1+max2+max3;
		return (long) fin;
	}
}
