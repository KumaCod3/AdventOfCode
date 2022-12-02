package aOc22;
import java.util.ArrayList;
import program.Read;

public class Day02_2022 {
	public static long calculate1(String s) {
		ArrayList<String[]> lista = Read.copList(s);
		int fin=0;
		
		for (String[] a: lista) {
			if (a[0].equals("A")) {
				if (a[1].equals("X")) {
					fin=fin+(3+1);
				}
				else  if (a[1].equals("Y")) {
					fin=fin+(6+2);
				}
				else  if (a[1].equals("Z")) {
					fin=fin+(0+3);
				}
			}
			else if (a[0].equals("B")) {
				if (a[1].equals("X")) {
					fin=fin+(0+1);
				}
				else  if (a[1].equals("Y")) {
					fin=fin+(3+2);
				}
				else  if (a[1].equals("Z")) {
					fin=fin+(6+3);
				}
			}
			else if (a[0].equals("C")) {
				if (a[1].equals("X")) {
					fin=fin+(6+1);
				}
				else  if (a[1].equals("Y")) {
					fin=fin+(0+2);
				}
				else  if (a[1].equals("Z")) {
					fin=fin+(3+3);
				}
			}
		}
		System.out.println("OOOOK");
		return (long) fin;
	}
	public static long calculate2(String s) {
		ArrayList<String[]> lista = Read.copList(s);
		int fin=0;
		
		for (String[] a: lista) {
			if (a[0].equals("A")) {
				if (a[1].equals("X")) {
					fin=fin+(0+3);
				}
				else  if (a[1].equals("Y")) {
					fin=fin+(3+1);
				}
				else  if (a[1].equals("Z")) {
					fin=fin+(6+2);
				}
			}
			else if (a[0].equals("B")) {
				if (a[1].equals("X")) {
					fin=fin+(0+1);
				}
				else  if (a[1].equals("Y")) {
					fin=fin+(3+2);
				}
				else  if (a[1].equals("Z")) {
					fin=fin+(6+3);
				}
			}
			else if (a[0].equals("C")) {
				if (a[1].equals("X")) {
					fin=fin+(0+2);
				}
				else  if (a[1].equals("Y")) {
					fin=fin+(3+3);
				}
				else  if (a[1].equals("Z")) {
					fin=fin+(6+1);
				}
			}
		}
		return (long) fin;
	}
}
