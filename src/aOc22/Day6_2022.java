package aOc22;
import java.util.ArrayList;
import java.util.HashMap;
import program.Read;

public class Day6_2022 {
	public static long calculate1(String s) {
		int fin=0;
		ArrayList<String> list=Read.singl(s);
		
		for (int i=0;i<list.size()-4;i++) {
			char[] pro=new char[4];
			for (int h=0;h<4;h++) {
				fin=i+h;
				pro[h]=list.get(i+h).charAt(0);
			}
			if (noD(pro)) {
				break;
			}
		}
		return (long) fin+1;
	}
	
	public static long calculate2(String s) {
		int fin=0;
		ArrayList<String> list=Read.singl(s);
		
		for (int i=0;i<list.size()-14;i++) {
			char[] pro=new char[14];
			for (int h=0;h<14;h++) {
				fin=i+h;
				pro[h]=list.get(i+h).charAt(0);
			}
			if (noDl(pro)) {
				break;
			}
		}
		
		return (long) fin+1;
	}
	
	private static  boolean noD(char[] in) {
		if (in[0]==in[1]||in[0]==in[2]||in[0]==in[3]||in[1]==in[2]||in[1]==in[3]||in[2]==in[3]) {
			return false;
		}
		return true;
	}
	private static  boolean noDl(char[] in) {
		HashMap<Character,Integer> lis=new HashMap<Character,Integer>();
		for (char c:in) {
			lis.put(c,5);
		}
		if (lis.size()<14) {
			return false;
		}
		return true;
	}
}
