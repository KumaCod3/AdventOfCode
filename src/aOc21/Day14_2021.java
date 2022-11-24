package aOc21;
import java.util.HashMap;

import program.Nope;
import program.Read;

public class Day14_2021 {
	public static long calculate1(String s) {
		String[] inp=s.split("\\n\\n");
		String cod = inp[0];
		String codBis = "";
		int max = 0;
		int ris = 0;
		int t=0;
		int min = 1000;
		HashMap<String, String> rules = Read.rule(inp[1]);
		HashMap<String, Integer> conta = new HashMap<String, Integer>();

// apply rules for 10 times
		while (t < 10) {

			for (int i = 0; i < cod.length() - 1; i++) {
				String sub = "" + cod.charAt(i) + cod.charAt(i + 1);
				codBis = codBis + cod.charAt(i) + rules.get(sub);
			}
			codBis = codBis + cod.charAt(cod.length() - 1);
			cod = codBis;
			codBis = "";
			t++;
		}

// make map:
		for (int i = 0; i < cod.length(); i++) {
			conta.put(String.valueOf(cod.charAt(i)), 0);
		}

// count letters
		for (int i = 0; i < cod.length(); i++) {
			conta.put(String.valueOf(cod.charAt(i)), conta.get(String.valueOf(cod.charAt(i))) + 1);
		}

// find max e min rep
		for (int value : conta.values()) {
			if (max < value) {
				max = value;
			}
			if (min > value) {
				min = value;
			}
		}
// print difference
		ris = max - min;
		return (long) ris;
	}
	
	public static long calculate2(String s) {
		Nope no=new Nope();
		no.setVisible(true);
		
		return 0l;
	}
}
