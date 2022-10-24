package aOc22;
import java.util.LinkedList;
import java.util.List;

public class Day06_2021 {
	public static long calculate1(String s) {
		List<Integer> lantern = Read.intVirList(s);
		int t=0;
		
		for (int p = 0; p < 80; p++) {
			for (int i = 0; i < lantern.size(); i++) {
				if (lantern.get(i) == 0) {
					t++;
					lantern.set(i, 6);
				} else {
					lantern.set(i, lantern.get(i) - 1);
				}
			}
			for (int u = 0; u < t; u++) {
				lantern.add(8);
			}
			t = 0;
		}
		int fin=lantern.size();
		Tool.bell();
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		List<Integer> lantern = Read.intVirList(s);
		long[] groupA = { 1, 0 };
		long[] groupB = { 2, 0 };
		long[] groupC = { 3, 0 };
		long[] groupD = { 4, 0 };
		long[] groupE = { 5, 0 };
		long[] groupF = { 6, 0 };
		long[] groupG = { 0, 0 };
		long[] babyA = { 1, 0 };
		long[] babyB = { 0, 0 };
		long bb = 0;
		long aa = 0;
		int days = 256;
		long x=1;
		int t = 0;
		LinkedList<long[]> pool = new LinkedList<long[]>();
		
		for (int u : lantern) {
			if (u == 0) {
				groupG[1] = groupG[1] + x;
			} else if (u == 1) {
				groupA[1] = groupA[1] + x;
			} else if (u == 2) {
				groupB[1] = groupB[1] + x;
			} else if (u == 3) {
				groupC[1] = groupC[1] + x;
			} else if (u == 4) {
				groupD[1] = groupD[1] + x;
			} else if (u == 5) {
				groupE[1] = groupE[1] + x;
			} else if (u == 6) {
				groupF[1] = groupF[1] + x;
			}
		}

// metto tutto dentro list pool
		pool.add(groupA);
		pool.add(groupB);
		pool.add(groupC);
		pool.add(groupD);
		pool.add(groupE);
		pool.add(groupF);
		pool.add(groupG);

// FACCIO PASSARE GIORNI
		while (t < days) {
			for (long[] u : pool) {
				u[0] = u[0] - x;
				if (u[0] < 0) {
					u[0] = 6;
					bb = u[1];
				}

			}
			babyA[0] = babyA[0] - x;
			babyB[0] = babyB[0] - x;
			if (babyA[0] < 0) {
				aa = babyA[1];
				babyA[0] = 1;
				babyA[1] = bb;
			} else if (babyB[0] < 0) {
				aa = babyB[1];
				babyB[0] = 1;
				babyB[1] = bb;
			}
			for (long[] u : pool) {
				if (u[0] == 6) {
					u[1] = u[1] + aa;
				}
			}
			aa = 0;
			bb = 0;
			t++;
		}
		long tot = 0;
		for (long[] u : pool) {
			tot = tot + u[1];
		}
		tot = tot + babyB[1] + babyA[1];

		return tot;
	}
}
