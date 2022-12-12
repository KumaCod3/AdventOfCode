package aOc22;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import program.Read;

public class Day11_2022 {
	public static HashMap<Integer, Monkey> scimmie=new HashMap<Integer, Monkey>(); 
	public static HashMap<Integer, MonkeyBig> scimmione=new HashMap<Integer, MonkeyBig>(); 
	
	public static long calculate1(String s) {
		int fin=0;
		int rounds=20;
		ArrayList<String[]> list = Read.monk(s);
			
		for (String[] mon:list) {			
			int nome=-1;
			ArrayList<Integer> ogg=new ArrayList<Integer>();
			int opVal=-1;
			int opp=-1;
			
			// riga 1
			String riga=mon[0];
			riga=riga.replaceAll(":", "");
			riga=riga.trim();
			String[] ri=riga.split(" ");
			nome=Integer.parseInt(ri[1]);
			// riga 2
			riga=mon[1];
//			System.out.println("riga: "+riga);
			riga=riga.replaceAll(",", "");
			riga=riga.trim();
			String[] ri1=riga.split(" ");
//			System.out.println(Arrays.toString(ri1));
			for (int i=2;i<ri1.length; i++) {
				int x=Integer.parseInt(ri1[i]);
				ogg.add(x);
			}
			// riga 3
			riga=mon[2];
			riga=riga.trim();
			String[] ri2=riga.split(" ");
			try { opVal=Integer.parseInt(ri2[ri2.length-1]); }
				catch (Exception e) {opp=3;}
			String ooo=ri2[ri2.length-2];
			switch (ooo) {
			case "+":
				opp=1;
				break;
			case "*":
				if (opp==-1) {
					opp=2;
				}
				break;
			}
			// riga 4
			riga=mon[3];
			riga=riga.trim();
			String[] ri3=riga.split(" ");
			int co=Integer.parseInt(ri3[3]);
			// riga 5
			riga=mon[4];
			riga=riga.trim();
			String[] ri4=riga.split(" ");
			int t=Integer.parseInt(ri4[5]);
			// riga 6
			riga=mon[5];
			riga=riga.trim();
			String[] ri5=riga.split(" ");
			int f=Integer.parseInt(ri5[5]);
			
			Monkey mm=new Monkey(nome, opp, opVal , co, t,  f, ogg);
			scimmie.put(nome, mm);
		}
		
		for (int i=0;i<rounds;i++) {
			for (Monkey m:scimmie.values()) {
				m.doo();
			}
		}
		
		int[] act=new int[scimmie.size()];
		for (int i=0;i<scimmie.size();i++) {
			act[i]=scimmie.get(i).act;
		}
		Arrays.sort(act);
		int tre=act[act.length-1];
		int qua=act[act.length-2];
		fin=tre*qua;
		return (long) fin;
	}

	public static long calculate2(String s) {
		long fin=0;
		int rounds=10000;
		ArrayList<String[]> list = Read.monk(s);
		
		for (String[] mon:list) {
			int nome=-1;
			ArrayList<Long> ogg=new ArrayList<Long>();
			int opVal=-1;
			int opp=-1;
			
			// riga 1
			String riga=mon[0];
			riga=riga.replaceAll(":", "");
			riga=riga.trim();
			String[] ri=riga.split(" ");
			nome=Integer.parseInt(ri[1]);
			// riga 2
			riga=mon[1];
			riga=riga.replaceAll(",", "");
			riga=riga.trim();
			String[] ri1=riga.split(" ");
			for (int i=2;i<ri1.length; i++) {
				long x=Long.parseLong(ri1[i]);
				ogg.add(x);
			}
			// riga 3
			riga=mon[2];
			riga=riga.trim();
			String[] ri2=riga.split(" ");
			try { opVal=Integer.parseInt(ri2[ri2.length-1]); }
				catch (Exception e) {opp=3;}
			String ooo=ri2[ri2.length-2];
			switch (ooo) {
			case "+":
				opp=1;
				break;
			case "*":
				if (opp==-1) {
					opp=2;
				}
				break;
			}
			// riga 4
			riga=mon[3];
			riga=riga.trim();
			String[] ri3=riga.split(" ");
			int co=Integer.parseInt(ri3[3]);
			// riga 5
			riga=mon[4];
			riga=riga.trim();
			String[] ri4=riga.split(" ");
			int t=Integer.parseInt(ri4[5]);
			// riga 6
			riga=mon[5];
			riga=riga.trim();
			String[] ri5=riga.split(" ");
			int f=Integer.parseInt(ri5[5]);
			
			MonkeyBig mm=new MonkeyBig(nome, opp, opVal , co, t,  f, ogg);
			scimmione.put(nome, mm);
		}
		
		for (int i=0;i<rounds;i++) {
			for (MonkeyBig m:scimmione.values()) {
				m.doo();
			}
		}
		
		int[] act=new int[scimmione.size()];
		for (int i=0;i<scimmione.size();i++) {
			act[i]=scimmione.get(i).act;
		}
		Arrays.sort(act);
		long tre=(long) act[act.length-1];
		long qua=(long) act[act.length-2];
		fin=tre*qua;
		return fin;
	}
}
