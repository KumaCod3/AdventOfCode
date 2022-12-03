package aOc22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import program.Read;

public class Day03_2022 {
	private static HashMap<Character,Integer> map=new HashMap<Character,Integer>();
	
	public static long calculate1(String s) {
		int fin=0;
		ArrayList<char[]> lista = Read.copListCh(s);
		populate();
		
		for (char[] a:lista) {
			int mez=a.length/2;
			boolean tr=true;
			while (tr) {
				for (int i=0;i<mez;i++) {
					if (tr==false) {
						break;
					}
					for (int h=mez;h<a.length;h++) {
						if (a[i]==(a[h])) {
							int pp=map.get(a[i]);
							fin=fin+pp;
							tr=false;
							break;
						}
					}
				
				}
			}
		}
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		int fin=0;
		ArrayList<char[]> lista = Read.copListCh(s);
		populate();
		
		for (int i=0;i<lista.size()-2;i=i+3) {
			char[] uno=lista.get(i);
			char[] due=lista.get(i+1);
			char[] tre=lista.get(i+2);
			char x='q';
			for (char w:uno) {
				for (char e:due) {
					for (char r:tre) {
						if (w==e&&e==r) {
							x=w;
						}
					}
				}
			}
			int pp=map.get(x);
			fin=fin+pp;
		}
		return (long) fin;
	}
	
	static private void populate() {
		if (map.size()==0) {
			map.put('a',1);
			map.put('b',2);
			map.put('c',3);
			map.put('d',4);
			map.put('e',5);
			map.put('f',6);
			map.put('g',7);
			map.put('h',8);
			map.put('i',9);
			map.put('j',10);
			map.put('k',11);
			map.put('l',12);
			map.put('m',13);
			map.put('n',14);
			map.put('o',15);
			map.put('p',16);
			map.put('q',17);
			map.put('r',18);
			map.put('s',19);
			map.put('t',20);
			map.put('u',21);
			map.put('v',22);
			map.put('w',23);
			map.put('x',24);
			map.put('y',25);
			map.put('z',26);
			map.put('A',27);
			map.put('B',28);
			map.put('C',29);
			map.put('D',30);
			map.put('E',31);
			map.put('F',32);
			map.put('G',33);
			map.put('H',34);
			map.put('I',35);
			map.put('J',36);
			map.put('K',37);
			map.put('L',38);
			map.put('M',39);
			map.put('N',40);
			map.put('O',41);
			map.put('P',42);
			map.put('Q',43);
			map.put('R',44);
			map.put('S',45);
			map.put('T',46);
			map.put('U',47);
			map.put('V',48);
			map.put('W',49);
			map.put('X',50);
			map.put('Y',51);
			map.put('Z',52);
		}
	}
}
