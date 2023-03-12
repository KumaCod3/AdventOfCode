package aOc21;
import java.util.LinkedList;
import java.util.List;
import program.Read;

public class Day6_2021 {
	private static final int DAY1=80;
	private static final int DAY2=256;
	
	public static long calculate1(String s) {
		return calculate(s, DAY1);
	}
	
	public static long calculate2(String s) {
		return calculate(s, DAY2);
	}
	
	public static long calculate(String s, int days) {
		List<Integer> lantern = Read.intVirList(s);
		long[] groupA = { 1, 0 };
		long[] groupB = { 2, 0 };
		long[] groupC = { 3, 0 };
		long[] groupD = { 4, 0 };
		long[] groupE = { 5, 0 };
		long[] groupF = { 6, 0 };
		long[] groupG = { 0, 0 };
		long[] groupH = { 7, 0 };
		long[] groupI = { 8, 0 };
		long bb = 0;
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
		pool.add(groupH);
		pool.add(groupI);

// FACCIO PASSARE GIORNI
		while (t < days) {
			for (long[] u : pool) {
				u[0] = u[0] - x;
				if (u[0] < 0) {
					u[0] = 8;
					bb = u[1];
				}

			}
			for (long[] u : pool) {
				if (u[0] == 6) {
					u[1] = u[1] + bb;
				}
			}
			bb = 0;
			t++;
		}
		long tot = 0;
		for (long[] u : pool) {
			tot = tot + u[1];
		}
		
		return tot;
	}
}
