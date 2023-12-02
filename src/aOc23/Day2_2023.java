package aOc23;
import java.util.ArrayList;
import java.util.Arrays;
import program.Read;

public class Day2_2023 {
	public static long calculate1(String s) {
		ArrayList<String> lista = (ArrayList<String>) Read.striList(s);
		ArrayList<int[]> colori= new ArrayList<int[]>();
		for (String ss:lista) {
			String[] temp=ss.split("[;:,]");
			int[] col=new int[4];
			for (String sss:temp) {
				if (sss.contains("red")) {
					int n=0;
					String nn="";
					for (int i=0;i<sss.length();i++) {
						if (Character.isDigit(sss.charAt(i))) {
							nn=nn+sss.charAt(i);
						}
					}
					n=Integer.parseInt(nn);
					if (col[0]<n) {
						col[0]=n;
					}
//					System.out.println("red "+n);
				}
				else if (sss.contains("green")) {
					int n=0;
					String nn="";
					for (int i=0;i<sss.length();i++) {
						if (Character.isDigit(sss.charAt(i))) {
							nn=nn+sss.charAt(i);
						}
					}
					n=Integer.parseInt(nn);
					if (col[1]<n) {
						col[1]=n;
					}
//					System.out.println("green "+n);
				}
				else if (sss.contains("blue")) {
					int n=0;
					String nn="";
					for (int i=0;i<sss.length();i++) {
						if (Character.isDigit(sss.charAt(i))) {
							nn=nn+sss.charAt(i);
						}
					}
					n=Integer.parseInt(nn);
					if (col[2]<n) {
						col[2]=n;
					}
//					System.out.println("blue "+n);
				}
				else {
					int n=0;
					String nn="";
					for (int i=0;i<sss.length();i++) {
						if (Character.isDigit(sss.charAt(i))) {
							nn=nn+sss.charAt(i);
						}
					}
					n=Integer.parseInt(nn);
					col[3]=n;
//					System.out.println("riga "+n);
				}
			}
			colori.add(col);
			System.out.println("riga "+Arrays.toString(col));
		}
		int[] verif= {12, 13, 14};
		int tot=0;
		for (int[] gruppo:colori) {
			if (gruppo[0]<=verif[0]&&gruppo[1]<=verif[1]&&gruppo[2]<=verif[2]) {
				tot=tot+gruppo[3];
				System.out.println("buono "+gruppo[3]);
				System.out.println(" rosse"+gruppo[0]+" verdi"+gruppo[1]+" blu"+gruppo[2]);
			}
		}
		
		return (long) tot;
	}
	public static long calculate2(String s) {
		ArrayList<String> lista = (ArrayList<String>) Read.striList(s);
		ArrayList<int[]> colori= new ArrayList<int[]>();
		for (String ss:lista) {
			String[] temp=ss.split("[;:,]");
			int[] col=new int[4];
			for (String sss:temp) {
				if (sss.contains("red")) {
					int n=0;
					String nn="";
					for (int i=0;i<sss.length();i++) {
						if (Character.isDigit(sss.charAt(i))) {
							nn=nn+sss.charAt(i);
						}
					}
					n=Integer.parseInt(nn);
					if (col[0]<n) {
						col[0]=n;
					}
//					System.out.println("red "+n);
				}
				else if (sss.contains("green")) {
					int n=0;
					String nn="";
					for (int i=0;i<sss.length();i++) {
						if (Character.isDigit(sss.charAt(i))) {
							nn=nn+sss.charAt(i);
						}
					}
					n=Integer.parseInt(nn);
					if (col[1]<n) {
						col[1]=n;
					}
//					System.out.println("green "+n);
				}
				else if (sss.contains("blue")) {
					int n=0;
					String nn="";
					for (int i=0;i<sss.length();i++) {
						if (Character.isDigit(sss.charAt(i))) {
							nn=nn+sss.charAt(i);
						}
					}
					n=Integer.parseInt(nn);
					if (col[2]<n) {
						col[2]=n;
					}
//					System.out.println("blue "+n);
				}
				else {
					int n=0;
					String nn="";
					for (int i=0;i<sss.length();i++) {
						if (Character.isDigit(sss.charAt(i))) {
							nn=nn+sss.charAt(i);
						}
					}
					n=Integer.parseInt(nn);
					col[3]=n;
//					System.out.println("riga "+n);
				}
			}
			colori.add(col);
			System.out.println("riga "+Arrays.toString(col));
		}
		
		long tot=0;
		for (int[] gruppo:colori) {
			int mol=gruppo[0]*gruppo[1]*gruppo[2];
			tot=tot+mol;
		}
		return tot;
	}
}
