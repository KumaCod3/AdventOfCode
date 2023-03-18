package aOc21;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import program.Nope;
import program.Prova;
import program.Read;

public class Day14_2021 {
	static HashMap<String, String> rules=new HashMap<String, String>();
	static String ultim;
	
	public static long calculate1(String s) {
		String[] inp=s.split("\\n\\n");
		String cod = inp[0];
		rules = Read.rule(inp[1]);
		Long max;
		Long ris;
		Long min;
		int rep=40;
		String fin="";
		
		for (int i=0;i<rep;i++) {
			fin=listalo(cod).stream().map(Prova::insert).reduce((a,b) -> a+b ).orElse("");
			cod=fin+ultim;
			System.out.println("giro "+i);
		}
		
		var conteggio=cod.chars().mapToObj(c -> (char) c)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		min=conteggio.values().stream().min(Comparator.comparing(Function.identity())).orElse(1l);
		max=conteggio.values().stream().max(Comparator.comparing(Function.identity())).orElse(1l);
		
		ris = max - min;
		return (long) ris;
		
	}
	
	public static ArrayList<String> listalo(String s) {
		ArrayList<String> coppie=new ArrayList<String>();
		ultim=s.charAt(s.length()-1)+"";
		for (int i=0;i<s.length()-1;i++) {
			String sub=""+s.charAt(i)+s.charAt(i+1)+"";
			coppie.add(sub);
		}
		
		return coppie;
	}
	
	public static String insert(String cop) {
		String insert=rules.get(cop);
		String codBis = cop.charAt(0)+insert;
		return codBis;
	}
	
	public static long calculate2(String s) {
		Nope nn=new Nope();
		nn.setVisible(true);
	//	https://en.wikipedia.org/wiki/Matrix_multiplication
		return (long) 0;
	}
}
