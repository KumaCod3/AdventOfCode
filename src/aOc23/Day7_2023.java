package aOc23;
import java.util.ArrayList;
import java.util.Collections;
import program.Read;

public class Day7_2023 {
	public static long calculate1(String s) {
		Long fin=0l;
		ArrayList<String[]> lista = Read.elep(s);
		ArrayList<PokerDay7> lis = new ArrayList<PokerDay7>();
		for (String[] a:lista) {
			PokerDay7 nn=new PokerDay7(a);
			lis.add(nn);
		}
		Collections.sort(lis);
		
		for (int i=0;i<lis.size();i++) {
			Long val=lis.get(i).bid*((long)i+1);
			lis.get(i).valoreF=val;
			fin=fin+val;
		}
		return fin;
	}
	
	public static long calculate2(String s) {
		Long fin=0l;
		ArrayList<String[]> lista = Read.elep(s);
		ArrayList<PokerDay7p2> lis = new ArrayList<PokerDay7p2>();
		for (String[] a:lista) {
			PokerDay7p2 nn=new PokerDay7p2(a);
			lis.add(nn);
		}
		Collections.sort(lis);
		
		for (int i=0;i<lis.size();i++) {
			Long val=lis.get(i).bid*((long)i+1);
			lis.get(i).valoreF=val;
			fin=fin+val;
		}
		return fin;
	}
}
