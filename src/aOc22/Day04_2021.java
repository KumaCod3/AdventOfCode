package aOc22;
import java.util.LinkedList;

public class Day04_2021 {

	public static long calculate1(String s) {
		LinkedList<int[][]> originali = new LinkedList<int[][]>();
		LinkedList<int[][]> temp = new LinkedList<int[][]>();
		boolean vero = true;
		int ris = 0;
		int tot = 0;
		int[][] win = new int[5][5];
		
		String[] inp=s.split("\\n\\n");
		System.out.println("dovrebbe essere alto: " +inp.length);
		String line = inp[0].trim();
		String[] numbers = line.split(",");
		int[] pescati = new int[numbers.length];
		for (int i = 0; i < pescati.length; i++) {
			pescati[i] = Integer.valueOf(numbers[i]);
		}

		// make List of input tablet
		for (int i=1;i<inp.length;i++) {
			int[][] num = new int[5][5];
			String[] lines=inp[i].split("\\n");
			for(int j=0;j<lines.length;j++) {
				String[] linea=lines[j].split(" ");
				int[] riga=new int[5];
				int h=0;
				for (String st:linea) {
					try {
						riga[h]=Integer.parseInt(st);
						h++;
					}
					catch (Exception e) {
						
					}
				}
				num[j]=riga;
			}
			originali.add(i-1, num);
		}

		for (int m : pescati) {
			ris = m;
			for (int[][] e : (pesca(originali, m))) {
				temp.add(e);
			}
			for (int[][] u : temp) {
				if (check(u) == true) {
					win = u;
					vero = false;
					break;
				}
			}
			if (vero == false) {
				break;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (win[i][j] == (-10)) {
					win[i][j] = 0;
				} else {
					tot = tot + win[i][j];
				}
			}
		}
		
		return (long) (tot * ris);
	}
	public static long calculate2(String s) {
		LinkedList<int[][]> originali = new LinkedList<int[][]>();
		LinkedList<int[][]> temp = new LinkedList<int[][]>();
		int ris = 0;
		int tot = 0;
		int[][] win = new int[5][5];
		
		String[] inp=s.split("\\n\\n");
		String line = inp[0].trim();
		String[] numbers = line.split(",");
		int[] pescati = new int[numbers.length];
		for (int i = 0; i < pescati.length; i++) {
			pescati[i] = Integer.valueOf(numbers[i]);
		}

		// make List of input tablet
		for (int i=1;i<inp.length;i++) {
			int[][] num = new int[5][5];
			String[] lines=inp[i].split("\\n");
			for(int j=0;j<lines.length;j++) {
				String[] linea=lines[j].split(" ");
				int[] riga=new int[5];
				int h=0;
				for (String st:linea) {
					try {
						riga[h]=Integer.parseInt(st);
						h++;
					}
					catch (Exception e) {
						
					}
				}
				num[j]=riga;
			}
			originali.add(i-1, num);
		}
		for (int m : pescati) {
			ris = m;
			pesca(originali, m);
			for (int[][] u : originali) {
				if (check(u) == false) {
					temp.add(u);
				}
			}
			if (originali.size() == 1) {
				break;
			}
			originali.clear();
			for (int[][] u : temp) {
				originali.add(u);
			}
			temp.clear();
		}
		win = originali.get(0);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (win[i][j] == (-10)) {
					win[i][j] = 0;
				} else if (win[i][j] == (999)) {
					win[i][j] = 0;
				} else {
					tot = tot + win[i][j];
				}
			}
		}

		return (long) (tot * ris);
	}
	
	
	// Method to put chosen number as -10 in tablets
		public static LinkedList<int[][]> pesca(LinkedList<int[][]> x, int y) {
			for (int[][] i : x) {
				for (int a = 0; a < 5; a++) {
					for (int b = 0; b < 5; b++) {
						if (i[a][b] == y) {
							i[a][b] = -10;
						}
					}
				}
			}
			return x;
		}

	// Method to verify if a table wins
		public static boolean check(int[][] m) {
			for (int i = 0; i < 5; i++) {
				if (m[i][0] + m[i][1] + m[i][2] + m[i][3] + m[i][4] < (-45)
						|| m[0][i] + m[1][i] + m[2][i] + m[3][i] + m[4][i] < (-45)) {
					return true;
				}
			}
			return false;
		}
}
