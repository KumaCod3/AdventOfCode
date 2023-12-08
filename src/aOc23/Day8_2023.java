package aOc23;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import program.Read;

public class Day8_2023 {
	public static long calculate1(String s) {
		Long fin=0l;
		ArrayList<String[]> lista = Read.desrt(s);
		HashMap<String, String[]> mappa=new HashMap<String, String[]>();
		String istruz=lista.get(0)[0];

		for (int i=2;i<lista.size();i++) {
			String k=lista.get(i)[0];
			String[] v= {lista.get(i)[1],lista.get(i)[2]};
			mappa.put(k, v);
		}
		
		int i=0;
		String index="AAA";
		while (!index.equals("ZZZ")) {
			if (i<istruz.length()) {
				char ist=istruz.charAt(i);
				String[] choi=mappa.get(index);
				if (ist=='L') {
					index=choi[0];
					i++;
					fin++;
				}
				else if (ist=='R') {
					index=choi[1];
					i++;
					fin++;
				}
			}
			else {
				i=0;
			}
		}
		return fin;
	}
	
	public static long calculate2(String s) {
		Long fin=1l;
		ArrayList<String[]> lista = Read.desrt(s);
		String istruz=lista.get(0)[0];
		HashMap<String, String[]> mappa=new HashMap<String, String[]>();
		for (int i=2;i<lista.size();i++) {
			String k=lista.get(i)[0];
			String[] v= {lista.get(i)[1],lista.get(i)[2]};
			mappa.put(k, v);
		}
		ArrayList<String> inizio=new ArrayList<String>();
		for (String ss:mappa.keySet()) {
			if (ss.charAt(2)=='A') {
				inizio.add(ss);
			}
		}
		Long[] win=new Long[inizio.size()];
		
		for (int x=0;x<inizio.size();x++) {
			String index=inizio.get(x);
			long f=0l;
			int i=0;
			while (index.charAt(2)!='Z') {
				if (i<istruz.length()) {
					char ist=istruz.charAt(i);
					String[] choi=mappa.get(index);
					if (ist=='L') {
						index=choi[0];
						i++;
						f++;
					}
					else if (ist=='R') {
						index=choi[1];
						i++;
						f++;
					}
				}
				else {
					i=0;
				}
			}
			win[x]=f;
		}
		
		System.out.println(Arrays.toString(win));
		for (Long f:win) {
			fin=lcm(fin,f);
		}
		return fin;
	}	
	
	 static long gcd(long a, long b) { 
		if (a == 0) 
	            return b; 
        return gcd(b % a, a);  
    } 
	      
    static long lcm(long a, long b) { 
        return (a / gcd(a, b)) * b; 
    } 
}