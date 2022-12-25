package aOc22;
import java.util.ArrayList;
import program.Read;
import program.Show;

public class Day25_2022 {
	public static long calculate1(String s) {
		double fin=0;
		double fineee=0;
		ArrayList<int[]> list= Read.snafu(s);
		for (int[] a:list) {
			double ff=0;
			for (int i=0;i<a.length;i++) {
				double f=a[i];
				f=f*(Math.pow(5, i));
				ff=ff+f;
			}
			fin=fin+ff;
		}
		fineee=fin;
		
		String fine="";
		while (fin>0) {
			double bin=fin%5;
			fine=""+calc(bin)+fine;
			fin=fin/5;
			fin=Math.round(fin);
		}
		Show ss=new Show(fine);
		ss.setVisible(true);
		return (long) fineee;
	}
	
	public static String calc(double b) {
		String f="";
		int bb=(int) b;
		switch (bb) {
			case 0:
				f="0";
				break;
			case 1:
				f="1";
				break;
			case 2:
				f="2";
				break;
			case 3:
				f="=";
				break;
			case 4:
				f="-";
				break;
		}
		return f;
	}
}
