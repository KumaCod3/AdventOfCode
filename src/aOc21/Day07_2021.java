package aOc21;
import java.util.List;

import program.Read;

public class Day07_2021 {
	public static long calculate1(String s) {
		List<Integer> lista=Read.intVirList(s);
		int fin=1000000;
		int ris=0;
		
		for (int y = 0; y < 2500; y++) {
			for (int x : lista) {
				ris = ris + Math.abs(x - y);
			}
			if (fin > ris) {
				fin = ris;
			}
			ris = 0;
		}
		
		
		return (long) fin;
	}
	public static long calculate2(String s) {
		List<Integer> crab=Read.intVirList(s);
		int ris=0;
		int tot = 0;
		float mid = 0;
		int media = 0;
		
		for (int x : crab) {
			tot = tot + x;
		}
		mid = (float) tot / (float) crab.size();
		media = (int) mid;
		if ((mid % (media + 0.5)) > 1) {
			media = media + 1;
		}

// sum crab carb consumption
		for (int x : crab) {
			int dist = Math.abs(x - media);
			for (int g = 0; g <= dist; g++) {
				ris = ris + g;
			}
		}
		
		return (long) ris;
	}
}
