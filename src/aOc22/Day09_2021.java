package aOc22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Day09_2021 {
	
	public static long calculate1(String s) {
		List<int[]> input = Read.intArList(s);
		HashSet<int[]> puntiB = new HashSet<int[]>();
		int ris=0;
		int conta = 0;
		LinkedList<Integer> basso = new LinkedList<Integer>();
		puntiB.clear();
		
		
		// find low points
				for (int m = 1; m < input.size() - 1; m++) {
					for (int n = 1; n < input.get(1).length - 1; n++) {
						if (input.get(m)[n] < input.get(m - 1)[n] && input.get(m)[n] < input.get(m + 1)[n]
								&& input.get(m)[n] < input.get(m)[n - 1] && input.get(m)[n] < input.get(m)[n + 1]) {
							basso.add(input.get(m)[n] + 1);
							puntiB.add(new int[] { m, n, conta });
							conta++;
						}
					}
				}
				for (int n = 1; n < input.get(0).length - 1; n++) {
					if (input.get(0)[n] < input.get(1)[n] && input.get(0)[n] < input.get(0)[n - 1]
							&& input.get(0)[n] < input.get(0)[n + 1]) {
						basso.add(input.get(0)[n] + 1);
						puntiB.add(new int[] { 0, n, conta });
						conta++;
					}
				}
				for (int n = 1; n < input.get(input.size() - 1).length - 1; n++) {
					if (input.get(input.size() - 1)[n] < input.get(input.size() - 2)[n]
							&& input.get(input.size() - 1)[n] < input.get(input.size() - 1)[n - 1]
							&& input.get(input.size() - 1)[n] < input.get(input.size() - 1)[n + 1]) {
						basso.add(input.get(input.size() - 1)[n] + 1);
						puntiB.add(new int[] { input.size() - 1, n, conta });
						conta++;
					}
				}
				for (int m = 1; m < input.size() - 1; m++) {
					if (input.get(m)[0] < input.get(m - 1)[0] && input.get(m)[0] < input.get(m + 1)[0]
							&& input.get(m)[0] < input.get(m)[1]) {
						basso.add(input.get(m)[0] + 1);
						puntiB.add(new int[] { m, 0, conta });
						conta++;
					}
				}
				for (int m = 1; m < input.size() - 1; m++) {
					if (input.get(m)[input.get(m).length - 1] < input.get(m - 1)[input.get(m).length - 1]
							&& input.get(m)[input.get(m).length - 1] < input.get(m + 1)[input.get(m).length - 1]
							&& input.get(m)[input.get(m).length - 1] < input.get(m)[input.get(m).length - 2]) {
						basso.add(input.get(m)[input.get(m).length - 1] + 1);
						puntiB.add(new int[] { m, input.get(m).length - 1, conta });
						conta++;
					}
				}
				if (input.get(0)[0] < input.get(0)[1] && input.get(0)[0] < input.get(1)[0]) {
					basso.add(input.get(0)[0] + 1);
					puntiB.add(new int[] { 0, 0, conta });
					conta++;
				}
				if (input.get(input.size() - 1)[0] < input.get(input.size() - 1)[1]
						&& input.get(input.size() - 1)[0] < input.get(input.size() - 2)[0]) {
					basso.add(input.get(input.size() - 1)[0] + 1);
					puntiB.add(new int[] { input.size() - 1, 0, conta });
					conta++;
				}
				if (input.get(input.size() - 1)[input.get(1).length - 1] < input.get(input.size() - 1)[input.get(1).length - 2]
						&& input.get(input.size() - 1)[input.get(1).length - 1] < input
								.get(input.size() - 2)[input.get(1).length - 1]) {
					basso.add(input.get(input.size() - 1)[input.get(1).length - 1] + 1);
					puntiB.add(new int[] { input.size() - 1, input.get(1).length - 1, conta });
					conta++;
				}
				if (input.get(0)[input.get(1).length - 1] < input.get(0)[input.get(1).length - 2]
						&& input.get(0)[input.get(1).length - 1] < input.get(1)[input.get(1).length - 1]) {
					basso.add(input.get(0)[input.get(1).length - 1] + 1);
					puntiB.add(new int[] { 0, input.get(1).length - 1, conta });
					conta++;
				}
				for (int u : basso) {
					ris = ris + u;
				}
		
		
		return (long) ris;
	}
	public static long calculate2(String s) {
		List<int[]> input = Read.intArList(s);
		int ris = 0;
		int conta = 0;
		LinkedList<Integer> basso = new LinkedList<Integer>();
		HashSet<int[]> puntiB = new HashSet<int[]>();
		
		// find low points
		for (int m = 1; m < input.size() - 1; m++) {
			for (int n = 1; n < input.get(1).length - 1; n++) {
				if (input.get(m)[n] < input.get(m - 1)[n] && input.get(m)[n] < input.get(m + 1)[n]
						&& input.get(m)[n] < input.get(m)[n - 1] && input.get(m)[n] < input.get(m)[n + 1]) {
					basso.add(input.get(m)[n] + 1);
					puntiB.add(new int[] { m, n, conta });
					conta++;
				}
			}
		}
		for (int n = 1; n < input.get(0).length - 1; n++) {
			if (input.get(0)[n] < input.get(1)[n] && input.get(0)[n] < input.get(0)[n - 1]
					&& input.get(0)[n] < input.get(0)[n + 1]) {
				basso.add(input.get(0)[n] + 1);
				puntiB.add(new int[] { 0, n, conta });
				conta++;
			}
		}
		for (int n = 1; n < input.get(input.size() - 1).length - 1; n++) {
			if (input.get(input.size() - 1)[n] < input.get(input.size() - 2)[n]
					&& input.get(input.size() - 1)[n] < input.get(input.size() - 1)[n - 1]
					&& input.get(input.size() - 1)[n] < input.get(input.size() - 1)[n + 1]) {
				basso.add(input.get(input.size() - 1)[n] + 1);
				puntiB.add(new int[] { input.size() - 1, n, conta });
				conta++;
			}
		}
		for (int m = 1; m < input.size() - 1; m++) {
			if (input.get(m)[0] < input.get(m - 1)[0] && input.get(m)[0] < input.get(m + 1)[0]
					&& input.get(m)[0] < input.get(m)[1]) {
				basso.add(input.get(m)[0] + 1);
				puntiB.add(new int[] { m, 0, conta });
				conta++;
			}
		}
		for (int m = 1; m < input.size() - 1; m++) {
			if (input.get(m)[input.get(m).length - 1] < input.get(m - 1)[input.get(m).length - 1]
					&& input.get(m)[input.get(m).length - 1] < input.get(m + 1)[input.get(m).length - 1]
					&& input.get(m)[input.get(m).length - 1] < input.get(m)[input.get(m).length - 2]) {
				basso.add(input.get(m)[input.get(m).length - 1] + 1);
				puntiB.add(new int[] { m, input.get(m).length - 1, conta });
				conta++;
			}
		}
		if (input.get(0)[0] < input.get(0)[1] && input.get(0)[0] < input.get(1)[0]) {
			basso.add(input.get(0)[0] + 1);
			puntiB.add(new int[] { 0, 0, conta });
			conta++;
		}
		if (input.get(input.size() - 1)[0] < input.get(input.size() - 1)[1]
				&& input.get(input.size() - 1)[0] < input.get(input.size() - 2)[0]) {
			basso.add(input.get(input.size() - 1)[0] + 1);
			puntiB.add(new int[] { input.size() - 1, 0, conta });
			conta++;
		}
		if (input.get(input.size() - 1)[input.get(1).length - 1] < input.get(input.size() - 1)[input.get(1).length - 2]
				&& input.get(input.size() - 1)[input.get(1).length - 1] < input
						.get(input.size() - 2)[input.get(1).length - 1]) {
			basso.add(input.get(input.size() - 1)[input.get(1).length - 1] + 1);
			puntiB.add(new int[] { input.size() - 1, input.get(1).length - 1, conta });
			conta++;
		}
		if (input.get(0)[input.get(1).length - 1] < input.get(0)[input.get(1).length - 2]
				&& input.get(0)[input.get(1).length - 1] < input.get(1)[input.get(1).length - 1]) {
			basso.add(input.get(0)[input.get(1).length - 1] + 1);
			puntiB.add(new int[] { 0, input.get(1).length - 1, conta });
			conta++;
		}
		for (int u : basso) {
			ris = ris + u;
		}
		System.out.println("Result for part 1: " + ris);
		System.out.println("dimensione puntiB prima: " + puntiB.size());
		int numero = puntiB.size();

// find basins
		int q = 0;
		LinkedList<int[]> temp = new LinkedList<int[]>();
		while (q == 0) {
			System.out.println("dimensione puntiB durante: " + puntiB.size());
			int controllo = puntiB.size();
			for (int[] a : puntiB) {
				try {
					if (input.get(a[0])[a[1]] < input.get(a[0] - 1)[a[1]] && input.get(a[0] - 1)[a[1]] != 9) {
						temp.add(new int[] { a[0] - 1, a[1], a[2] });
					}
				} catch (Exception e) {
				}
				try {
					if (input.get(a[0])[a[1]] < input.get(a[0] + 1)[a[1]] && input.get(a[0] + 1)[a[1]] != 9) {
						temp.add(new int[] { a[0] + 1, a[1], a[2] });
					}
				} catch (Exception e) {
				}
				try {
					if (input.get(a[0])[a[1]] < input.get(a[0])[a[1] - 1] && input.get(a[0])[a[1] - 1] != 9) {
						temp.add(new int[] { a[0], a[1] - 1, a[2] });
					}
				} catch (Exception e) {
				}
				try {
					if (input.get(a[0])[a[1]] < input.get(a[0])[a[1] + 1] && input.get(a[0])[a[1] + 1] != 9) {
						temp.add(new int[] { a[0], a[1] + 1, a[2] });
					}
				} catch (Exception e) {
				}
			}
			for (int[] a : temp) {
				boolean tr = false;
				for (int[] b : puntiB) {
					if (Arrays.equals(a, b)) {
						tr = true;
					}
				}
				if (tr == false) {
					puntiB.add(a);
				}
			}
			temp.clear();
			if (puntiB.size() == controllo) {
				q = 3;
				break;
			}
		}
		System.out.println("dimensione puntiB dopo: " + puntiB.size());

// count basins size an print result
		int[] finale = new int[numero];
		for (int i = 0; i < numero; i++) {
			int punti = 0;
			for (int[] a : puntiB) {
				if (a[2] == i) {
					punti = punti + 1;
				}
			}
			finale[i] = punti;
		}
		Arrays.sort(finale);
		int part2 = finale[numero - 1] * finale[numero - 2] * finale[numero - 3];


		Tool.bell();
		
		return (long) part2;
	}
}
