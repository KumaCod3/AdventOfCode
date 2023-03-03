package aOc21;
import java.util.ArrayList;
import java.util.LinkedList;

import program.Read;
import program.Show;

public class Day13_2021 {
	public static long calculate1(String s) {
		String[] spli=s.split("\\n\\n");
		LinkedList<int[]> input = Read.coor(spli[0]);
		ArrayList<String[]> pieghe =Read.pieg(spli[1]);
		int ris = 0;
		int piegaX = 0;
		int piegaY = 0;
		
		// fold the paper
				String[] a=pieghe.get(0);
//				for (String[] a : pieghe) {
					if (a[0].equals("x")) {
						piegaX = Integer.parseInt(a[1]);
					} else if (a[0].equals("y")) {
						piegaY = Integer.parseInt(a[1]);
					}

					if (piegaY > 0) {
						for (int[] i : input) {
							if (i[1] > piegaY) {
								i[1] = piegaY - (i[1] - piegaY);
							}
						}
					}
					if (piegaX > 0) {
						for (int[] i : input) {
							if (i[0] > piegaX) {
								i[0] = piegaX - (i[0] - piegaX);
							}
						}
					}
					piegaX = 0;
					piegaY = 0;
//				}
		// find x max and y max
				int xMax = 0;
				int yMax = 0;
				for (int[] i : input) {
					if (i[0] > xMax) {
						xMax = i[0];
					}
					if (i[1] > yMax) {
						yMax = i[1];
					}
				}
		// create the paper
				char[][] fin = new char[yMax + 1][xMax + 1];
				for (int i = 0; i < xMax; i++) {
					for (int h = 0; h < yMax; h++) {
						fin[h][i] = ' ';
					}
				}
		// draw the points
				for (int[] i : input) {
					if (fin[i[1]][i[0]] != '$') {
						fin[i[1]][i[0]] = '$';
						ris++;
					}
				}
		
		return (long) ris;
	}
	
	public static long calculate2(String s) {
		String[] spli=s.split("\\n\\n");
		LinkedList<int[]> input = Read.coor(spli[0]);
		ArrayList<String[]> pieghe =Read.pieg(spli[1]);
		int ris = 0;
		int piegaX = 0;
		int piegaY = 0;
		
		// fold the paper
				
				for (String[] a : pieghe) {
					if (a[0].equals("x")) {
						piegaX = Integer.parseInt(a[1]);
					} else if (a[0].equals("y")) {
						piegaY = Integer.parseInt(a[1]);
					}

					if (piegaY > 0) {
						for (int[] i : input) {
							if (i[1] > piegaY) {
								i[1] = piegaY - (i[1] - piegaY);
							}
						}
					}
					if (piegaX > 0) {
						for (int[] i : input) {
							if (i[0] > piegaX) {
								i[0] = piegaX - (i[0] - piegaX);
							}
						}
					}
					piegaX = 0;
					piegaY = 0;
				}
		// find x max and y max
				int xMax = 0;
				int yMax = 0;
				for (int[] i : input) {
					if (i[0] > xMax) {
						xMax = i[0];
					}
					if (i[1] > yMax) {
						yMax = i[1];
					}
				}
		// create the paper
				char[][] fin = new char[yMax + 1][xMax + 1];
				for (int i = 0; i <= xMax; i++) {
					for (int h = 0; h <= yMax; h++) {
						fin[h][i] = '-';
					}
				}
		// draw the points
				for (int[] i : input) {
					if (fin[i[1]][i[0]] != '$') {
						fin[i[1]][i[0]] = '$';
						ris++;
					}
				}

				Show fine=new Show(fin);
				fine.setVisible(true);
		
		return (long) ris;
	}
}
