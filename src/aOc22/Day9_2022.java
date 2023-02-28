package aOc22;
import java.util.ArrayList;
import java.util.LinkedList;
import program.Read;

public class Day9_2022 {
	static String t = "C";
	static int[][] plane = new int[10000][10000];
	static int[] pos = { 1000, 1000 };
	static LinkedList<int[]> coor = new LinkedList<int[]>();

	public static long calculate1(String s) {
		int fin = 0;
		ArrayList<String[]> list = Read.copList(s);
		plane[pos[0]][pos[1]] = 1;

		for (String[] a : list) {
			muovi(Integer.parseInt(a[1]),a[0]);
		}
		for (int[] in : plane) {
			for (int i : in) {
				fin = fin + i;
			}
		}
		return (long) fin;
	}

	public static long calculate2(String s) {
		int fin = 0;
		ArrayList<String[]> list = Read.copList(s);
		for (int i=0;i<11;i++) {
			int[] cor= {pos[0],pos[1]};
			coor.add(cor);
		}
		
		for (String[] a : list) {
			int mosse=Integer.parseInt(a[1]);
			String dire=a[0];
			for (int h=0;h<mosse;h++) {
				switch (dire) {
					case "R":
						coor.get(0)[1]=coor.get(0)[1]+1;
						break;
					case "L":
						coor.get(0)[1]=coor.get(0)[1]-1;
						break;
					case "U":
						coor.get(0)[0]=coor.get(0)[0]-1;
						break;
					case "D":
						coor.get(0)[0]=coor.get(0)[0]+1;
						break;
					
					}
				check();
				print();
			}
		}
		
		for (int[] in : plane) {
			for (int i : in) {
				fin = fin + i;
			}
		}
		return (long) fin;
	}

	private static void print() {
		int[] tail=coor.get(9);
		plane[tail[0]][tail[1]] = 1;
	}

	private static void check() {
		for (int i=1;i<coor.size();i++) {
			if (coor.get(i)[0]<coor.get(i-1)[0]-1) {
				coor.get(i)[0]=coor.get(i)[0]+1;
				if (coor.get(i)[1]<coor.get(i-1)[1]) {
					coor.get(i)[1]=coor.get(i)[1]+1;
				}
				else if (coor.get(i)[1]>coor.get(i-1)[1]) {
					coor.get(i)[1]=coor.get(i)[1]-1;
				}
			}
			else if (coor.get(i)[0]>coor.get(i-1)[0]+1) {
				coor.get(i)[0]=coor.get(i)[0]-1;
				if (coor.get(i)[1]<coor.get(i-1)[1]) {
					coor.get(i)[1]=coor.get(i)[1]+1;
				}
				else if (coor.get(i)[1]>coor.get(i-1)[1]) {
					coor.get(i)[1]=coor.get(i)[1]-1;
				}
				
			}
			else if (coor.get(i)[1]<coor.get(i-1)[1]-1) {
				coor.get(i)[1]=coor.get(i)[1]+1;
				if (coor.get(i)[0]<coor.get(i-1)[0]) {
					coor.get(i)[0]=coor.get(i)[0]+1;
				}
				else if (coor.get(i)[0]>coor.get(i-1)[0]) {
					coor.get(i)[0]=coor.get(i)[0]-1;
				}
			}
			else if (coor.get(i)[1]>coor.get(i-1)[1]+1) {
				coor.get(i)[1]=coor.get(i)[1]-1;
				if (coor.get(i)[0]<coor.get(i-1)[0]) {
					coor.get(i)[0]=coor.get(i)[0]+1;
				}
				else if (coor.get(i)[0]>coor.get(i-1)[0]) {
					coor.get(i)[0]=coor.get(i)[0]-1;
				}
				
			}
		}
		
	}
	
	private static void muovi(int x, String s) {
		for (int i=0;i<x;i++) {
			switch (s) {
				case "U":
					switch (t) {
						case "U":
							t = "c";
							break;
						case "L":
							t = "dl";
							break;
						case "D":
							moveU();
							break;
						case "R":
							t = "dr";
							break;
						case "DL":
							t = "d";
							moveUR();
							break;
						case "DR":
							t = "d";
							moveUL();
							break;
						case "UL":
							t = "l";
							break;
						case "UR":
							t = "r";
							break;
						case "C":
							t = "d";
							break;
					}
					break;
					
				case "L":
					switch (t) {
						case "U":
							t = "ur";
							break;
						case "L":
							t = "c";
							break;
						case "D":
							t="dr";
							break;
						case "R":
							moveL();
							break;
						case "DL":
							t = "d";
							break;
						case "DR":
							t = "r";
							moveUL();
							break;
						case "UL":
							t = "u";
							break;
						case "UR":
							moveDL();
							t = "r";
							break;
						case "C":
							t = "r";
							break;
						}
					
					break;
					
				case "D":
					switch (t) {
						case "U":
							t="u";
							moveD();
							break;
						case "L":
							t = "ul";
							break;
						case "D":
							t = "c";
							break;
						case "R":
							t = "ur";
							break;
						case "DL":
							t = "l";
							break;
						case "DR":
							t = "r";
							break;
						case "UL":
							t = "u";
							moveDR();
							break;
						case "UR":
							t = "u";
							moveDL();
							break;
						case "C":
							t = "u";
							break;
						}
					
					break;
					
				case "R":
					switch (t) {
						case "U":
							t = "ul";
							break;
						case "L":
							t ="l";
							moveR();
							break;
						case "D":
							t = "dl";
							break;
						case "R":
							t = "c";
							break;
						case "DL":
							t = "l";
							moveUR();
							break;
						case "DR":
							t = "d";
							break;
						case "UL":
							t = "l";
							moveDR();
							break;
						case "UR":
							t = "u";
							break;
						case "C":
							t = "l";
							break;
						}
				
				break;
			}
			t=t.toUpperCase();
		}

	}
	
	private static void moveD() {
		pos[0] = pos[0] + 1;
		plane[pos[0]][pos[1]] = 1;
	}
	
	private static void moveU() {
		pos[0] = pos[0] - 1;
		plane[pos[0]][pos[1]] = 1;
	}
	
	private static void moveL() {
		pos[1] = pos[1] - 1;
		plane[pos[0]][pos[1]] = 1;
	}
	
	private static void moveR() {
		pos[1] = pos[1] + 1;
		plane[pos[0]][pos[1]] = 1;
	}
	
	private static void moveDR() {
		pos[0] = pos[0] + 1;
		pos[1] = pos[1] + 1;
		plane[pos[0]][pos[1]] = 1;
	}
	
	private static void moveUR() {
		pos[0] = pos[0] - 1;
		pos[1] = pos[1] + 1;
		plane[pos[0]][pos[1]] = 1;
	}
	
	private static void moveDL() {
		pos[0] = pos[0] + 1;
		pos[1] = pos[1] - 1;
		plane[pos[0]][pos[1]] = 1;
	}
	
	private static void moveUL() {
		pos[0] = pos[0] - 1;
		pos[1] = pos[1] - 1;
		plane[pos[0]][pos[1]] = 1;
	}
	
}
