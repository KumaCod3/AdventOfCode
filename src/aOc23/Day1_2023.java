package aOc23;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import program.Read;

public class Day1_2023 {
	public static long calculate1(String s) {
		ArrayList<char[]> lista = Read.copListCh(s);
		int risultato=0;
		
		for (char[] c:lista) {
			ArrayList<Character> numeri= new ArrayList<Character>();
			for (char ch : c) {
				if (Character.isDigit(ch)) {
					numeri.add(ch);
				}
			}
			String fin=""+numeri.get(0)+numeri.get(numeri.size()-1);
			int ff=Integer.parseInt(fin);
			risultato+=ff;
		}
		return (long) risultato;
	}
	public static long calculate2(String s) {
		ArrayList<String> lista =(ArrayList<String>) Read.striList(s);
		int risultato=0;
		
		HashMap<String, Character> mappa=new HashMap<String, Character>();
		mappa.put("one", '1');
		mappa.put("two", '2');
		mappa.put("three", '3');
		mappa.put("four", '4');
		mappa.put("five", '5');
		mappa.put("six", '6');
		mappa.put("seven", '7');
		mappa.put("eight", '8');
		mappa.put("nine", '9');
		
		for (String c:lista) {
			ArrayList<Character> numeri= new ArrayList<Character>();
			
			for (int i=0; i<c.length();i++) {
				if (Character.isDigit(c.charAt(i))) {
					numeri.add(c.charAt(i));
				}
				else {
					for (Map.Entry<String, Character> ee:mappa.entrySet()) {
						int temp=ee.getKey().length();
						if (temp+i<=c.length()) {
							if (c.substring(i, i+temp).equals(ee.getKey())) {
								numeri.add(ee.getValue());
								continue;
							}
						}
						else if (temp==c.length()+1) {
							if (c.substring(i).equals(ee.getKey())) {
								numeri.add(ee.getValue());
								break;
							}
						}
						else {}
					}
				}
			}
			
			String fin=""+numeri.get(0)+numeri.get(numeri.size()-1);
			int ff=Integer.parseInt(fin);
			risultato+=ff;
		}
		return (long) risultato;
	}
}


