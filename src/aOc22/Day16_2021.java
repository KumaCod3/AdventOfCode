package aOc22;
import java.util.LinkedList;

public class Day16_2021 {
	public static long calculate1(String s) {
		int tot = 0;
		String binario = "";
		LinkedList<Integer> valoriH = new LinkedList<Integer>();

//  make string  BINARY 
		char[] input = new char[s.length()];
		for (int c = 0; c < s.length(); c++) {
			input[c] = s.charAt(c);
		}
		for (char a : input) {
			binario = converti(binario, a);
		}

// find
		int h = 0;
		while (h < binario.length() - 11) {
			valoriH.add(h);
			h = conta(h, binario);
		}

		for (int e : valoriH) {
			int ver = decimale(binario.substring(e, e + 3));
			tot = tot + ver;
		}
		
		return (long) tot;
	}
	
	public static long calculate2(String s) {
		int fin=0;
		
		Nope no=new Nope();
		no.setVisible(true);
		
		return (long) fin;
	}
	
	public static String converti(String a, char x) {
		if (x == '1') {
			a = a + "0001";
		} else if (x == '2') {
			a = a + "0010";
		} else if (x == '3') {
			a = a + "0011";
		} else if (x == '4') {
			a = a + "0100";
		} else if (x == '5') {
			a = a + "0101";
		} else if (x == '6') {
			a = a + "0110";
		} else if (x == '7') {
			a = a + "0111";
		} else if (x == '8') {
			a = a + "1000";
		} else if (x == '9') {
			a = a + "1001";
		} else if (x == 'A') {
			a = a + "1010";
		} else if (x == 'B') {
			a = a + "1011";
		} else if (x == 'C') {
			a = a + "1100";
		} else if (x == 'D') {
			a = a + "1101";
		} else if (x == 'E') {
			a = a + "1110";
		} else if (x == 'F') {
			a = a + "1111";
		} else if (x == '0') {
			a = a + "0000";
		}
		return a;
	}

// method to convert bin to dec
	public static int decimale(String a) {
		String[] d = a.split("");
		int[] w = new int[d.length];
		for (int i = 0; i < w.length; i++) {
			w[i] = Integer.parseInt(d[i]);
		}
		int[] bib = new int[w.length];
		for (int i = 0; i < w.length; i++) {
			bib[w.length - 1 - i] = (int) Math.pow(2, i);
		}
		int val = 0;
		for (int g = 0; g < w.length; g++) {
			val = val + (w[g] * bib[g]);
		}
		return val;
	}

// method to find h
	public static int conta(int x, String binario) {
		int h = x;
		int tipo = decimale(binario.substring(h + 3, h + 6));
		h = h + 6;
		if (tipo != 4) {
			if (binario.charAt(h) == '0') {
				h = h + 16;
			} else if (binario.charAt(h) == '1') {
				h = h + 12;

			}
		} else {
			int q = 0;
			while (q == 0) {
				if (binario.charAt(h) == '0') {
					h = h + 5;
					q = 1;
					break;
				} else {
					h = h + 5;
				}
			}
		}
		return h;
	}
}
