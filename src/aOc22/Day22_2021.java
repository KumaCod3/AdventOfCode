package aOc22;
import java.util.LinkedList;

public class Day22_2021 {
	public static long calculate1(String s) {
		LinkedList<int[]> comandi=Read.comandi(s,50);
		int[][][] cubo = new int[110][110][110];
		int ris=0;
		
		for (int[] i : comandi) {
			for (int x = i[1] + 51; x <= i[2] + 51; x++) {
				for (int y = i[3] + 51; y <= i[4] + 51; y++) {
					for (int z = i[5] + 51; z <= i[6] + 51; z++) {
						cubo[x][y][z] = i[0];
					}
				}
			}
		}

// count lit points
		for (int x = 0; x < cubo.length; x++) {
			for (int y = 0; y < cubo[0].length; y++) {
				for (int z = 0; z < cubo[0][0].length; z++) {
					if (cubo[x][y][z] == 1) {
						ris = ris + 1;
					}
				}
			}
		}
		return (long) ris;
	}
	
	public static long calculate2(String s) {
//		ArrayList<String[]> lista=Read.copList(s);
		int fin=0;
		
		
		
		
		return (long) fin;
	}
}
